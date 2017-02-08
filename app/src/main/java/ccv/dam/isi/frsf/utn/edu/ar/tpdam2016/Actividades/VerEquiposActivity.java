package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Adapter;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaEquipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

public class VerEquiposActivity extends AppCompatActivity  implements BusquedaFinalizadaListener<Equipo> {
    private ListView listView;

    ProgressDialog progressDialog;
    Adapter adapter;
    ArrayList<Equipo> listaEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView atras;
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ver_equipos);
        listView = (ListView) findViewById(R.id.listaEquipos);
        atras = (ImageView) findViewById(R.id.ivVerEquiposAtras);
        listaEquipos = new ArrayList<>();
        progressDialog = ProgressDialog.show(this, "Recopilando Equipos", "Aguarde unos instantes...");

        new BusquedaEquipo(this).execute("todos");

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),EquipoInicio.class);
                intent.putExtra("equipo", listView.getItemIdAtPosition(position)+1);
                startActivity(intent);
            }
        });
    }
    @Override
    public void busquedaFinalizada(ArrayList<Equipo> lista) {
        listaEquipos = lista;
        progressDialog.dismiss();
        adapter= new Adapter(getApplicationContext(), listaEquipos);
        listView.setAdapter(adapter);
    }

}
