package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Adapter;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class VerEquiposActivity extends AppCompatActivity {
    private ArrayList<Equipo> listaEquipos;
    private Adapter adapter;
    private ListView listView;
    private Button buscar;
    private ImageView atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ver_equipos);
        listView = (ListView) findViewById(R.id.listaEquipos);
        atras = (ImageView) findViewById(R.id.imageViewAtras);
        buscar = (Button) findViewById(R.id.buttonAhora);
        listaEquipos = new ArrayList<>();
        Conexion.buscarEquipos(listaEquipos);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(listaEquipos.size());
                if(!listaEquipos.isEmpty()){
                    adapter= new Adapter(getApplicationContext(), listaEquipos);
                    listView.setAdapter(adapter);
                }


            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });
    }

}
