package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Adapter;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

public class VerEquiposActivity extends AppCompatActivity {
    private ListView listView;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    ProgressDialog progressDialog;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView atras;
        ArrayList<Equipo> listaEquipos;
        getSupportActionBar().hide();

        setContentView(R.layout.activity_ver_equipos);
        listView = (ListView) findViewById(R.id.listaEquipos);
        atras = (ImageView) findViewById(R.id.ivVerEquiposAtras);
        listaEquipos = new ArrayList<>();
        progressDialog = ProgressDialog.show(this, "Recopilando Equipos", "Aguarde unos instantes...");
        buscarEquipos(listaEquipos);
        adapter= new Adapter(getApplicationContext(), listaEquipos);
        listView.setAdapter(adapter);


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
    public void buscarEquipos(final ArrayList<Equipo> listaEquipos){
        DatabaseReference posicionBD;
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
                listaEquipos.add(equipo);
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }
}
