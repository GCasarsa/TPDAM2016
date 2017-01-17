package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Adapter;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class VerEquiposActivity extends AppCompatActivity {
    ArrayList<Equipo> listaEquipos;
    Adapter adapter;
    ListView listView;
    Button buscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
/*        listView = (ListView) findViewById(R.id.listaEquipos);

        buscar = (Button) findViewById(R.id.buttonAhora);
        listaEquipos = new ArrayList<>();
        Conexion.buscarEquipos(listaEquipos);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter= new Adapter(getApplicationContext(), listaEquipos);
                listView.setAdapter(adapter);

            }
        });*/
    }

}
