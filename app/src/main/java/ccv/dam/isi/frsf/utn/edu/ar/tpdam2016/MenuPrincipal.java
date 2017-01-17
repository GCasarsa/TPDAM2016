package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        final Button verEquipos = (Button) findViewById(R.id.buttonVerEquipos);
        final Button cargarEquipos = (Button) findViewById(R.id.buttonCargarEquipos);
        final ListView listView = (ListView) findViewById(R.id.listaEquipos);

        final ArrayList<Equipo> listaEquipos = new ArrayList<>();

        Conexion.buscarEquipos(listaEquipos);


        verEquipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adapter adapter= new Adapter(getApplicationContext(), listaEquipos);
                listView.setAdapter(adapter);
                /*Intent intent = new Intent(getApplicationContext(), VerEquiposActivity.class);
                startActivity(intent);*/

            }
        });
        cargarEquipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexion.cargarEquipos();
            }
        });
    }
}
