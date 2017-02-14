package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaEquipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */

public class EquipoInicio extends FragmentActivity  implements BusquedaFinalizadaListener<Equipo>{

    private static ImageView atras, escudo;
    private static TextView titulo, nombre, lugar;
    private static Equipo equipo;
    private static CheckBox fav;
    ProgressDialog progressDialog;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        final String id = String.valueOf(getIntent().getExtras().getLong("equipo"));

        progressDialog = ProgressDialog.show(this, "Recopilando Información", "Aguarde unos instantes...");
        new BusquedaEquipo(this).execute(id);

        setContentView(R.layout.activity_equipo);
        escudo = (ImageView) findViewById(R.id.ivEquipoEscudo);
        lugar = (TextView) findViewById(R.id.tvEquipoLugar);
        nombre = (TextView) findViewById(R.id.tvEquipoNombre);
        titulo = (TextView) findViewById(R.id.tvEquipoTitulo);
        atras = (ImageView) findViewById(R.id.ivEquipoAtras);
        fav = (CheckBox) findViewById(R.id.checkBoxFav);


        // Obtengo las preferencias correspondientes a un equipo para ver si fue marcado como favorito

        Boolean esFavorito = pref.getBoolean(id,false);
        fav.setChecked(esFavorito);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                   Toast.makeText(getApplicationContext(), "Se ha agregado como equipo favorito", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putBoolean(id, true);
                    edit.commit();
                }
                else {
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putBoolean(id, false);
                    edit.commit();
                }
            }
        });
    }
    @Override
    public void busquedaFinalizada(ArrayList<Equipo> lista) {
        equipo = lista.get(0);

        nombre.setText(equipo.getNombre());
        titulo.setText(equipo.getNombre());
        lugar.setText(equipo.getCiudad() + "  -  " + equipo.getDivision());
        String url = equipo.getEscudo();
        if (url.length()>0)
            new DownloadImageTask().execute(url);

        AdapterTabs adapterTabs;
        ViewPager mViewPager;
        adapterTabs = new AdapterTabs(getSupportFragmentManager(), equipo);


        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapterTabs);


    }

    class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
        protected void onPreExecute() {}
        protected Drawable doInBackground(String... urls) {
            return downloadImage(urls[0]);
        }
        protected void onPostExecute(Drawable imagen) {
            escudo.setImageDrawable(imagen);
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Deslice la pantalla para navegar en el menú", Toast.LENGTH_SHORT).show();
        }
        private Drawable downloadImage(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                InputStream is = (InputStream)url.getContent();
                return Drawable.createFromStream(is, "src");
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(), VerEquiposActivity.class);
        startActivity(intent);
        finish();
    }


}
