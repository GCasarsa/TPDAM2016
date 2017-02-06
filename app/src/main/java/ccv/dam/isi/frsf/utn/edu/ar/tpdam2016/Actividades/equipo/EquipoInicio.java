package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

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
    private static TextView titulo, nombre;
    private static Equipo equipo;
    private static CheckBox fav;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = String.valueOf(getIntent().getExtras().getLong("equipo"));
        new BusquedaEquipo(this).execute(id);

        setContentView(R.layout.activity_equipo);
        escudo = (ImageView) findViewById(R.id.ivEquipoEscudo);
        nombre = (TextView) findViewById(R.id.tvEquipoNombre);
        titulo = (TextView) findViewById(R.id.tvEquipoTitulo);
        atras = (ImageView) findViewById(R.id.ivEquipoAtras);
        fav = (CheckBox) findViewById(R.id.checkBoxFav);



        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VerEquiposActivity.class);
                startActivity(intent);
            }
        });

        fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putBoolean(equipo.getId(), true);
                    edit.commit();
                }
                else {
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putBoolean(equipo.getId(), false);
                    edit.commit();
                }
            }
        });
    }
    @Override
    public void busquedaFinalizada(ArrayList<Equipo> lista) {
        if(!lista.isEmpty()){
            equipo = lista.get(0);
            nombre.setText(equipo.getNombre());
            titulo.setText(equipo.getNombre());
            AdapterTabs adapterTabs;
            ViewPager mViewPager;

            adapterTabs = new AdapterTabs(getSupportFragmentManager(), equipo);

            // Obtengo las preferencias correspondientes a un equipo para ver si fue marcado como favorito
            Boolean esFavorito = pref.getBoolean(equipo.getId(),false);
            fav.setChecked(esFavorito);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(adapterTabs);
            pref = PreferenceManager.getDefaultSharedPreferences(this);
            pref.edit().clear();
        }

    }
}
