package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTabs;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */
public class EquipoInicio extends FragmentActivity {

    private static ImageView atras, escudo;
    private static TextView titulo, nombre;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    private static Equipo equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = String.valueOf(getIntent().getExtras().getLong("equipo"));
        buscarEquipo(id);

        setContentView(R.layout.activity_equipo);
        escudo = (ImageView) findViewById(R.id.ivEquipoEscudo);
        nombre = (TextView) findViewById(R.id.tvEquipoNombre);
        titulo = (TextView) findViewById(R.id.tvEquipoTitulo);
        atras = (ImageView) findViewById(R.id.ivEquipoAtras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });

    }

    public void buscarEquipo(final String idEquipo){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id").equals(idEquipo)){
                    equipo = new Equipo(newPost.get("id").toString(),
                            newPost.get("nombre").toString(),
                            newPost.get("escudo").toString(),
                            newPost.get("division").toString(),
                            newPost.get("ciudad").toString(),
                            newPost.get("pais").toString(),
                            "",
                            Double.parseDouble(newPost.get("latitud").toString()),
                            Double.parseDouble(newPost.get("longitud").toString()),
                            newPost.get("descripcion").toString());
                    nombre.setText(equipo.getNombre());
                    titulo.setText(equipo.getNombre());
                    agregarEscudo();
                    AdapterTabs adapterTabs;
                    ViewPager mViewPager;

                    adapterTabs = new AdapterTabs(getSupportFragmentManager(), equipo);
                    mViewPager = (ViewPager) findViewById(R.id.pager);
                    mViewPager.setAdapter(adapterTabs);
                }
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

    public static void agregarEscudo(){
        if(equipo.getNombre().equals("ALDOSIVI")) escudo.setImageResource(R.drawable.escudo_aldosivi);
        else if(equipo.getNombre().equals("ARSENAL DE SARANDÍ")) escudo.setImageResource(R.drawable.escudo_arsenal);
        else if(equipo.getNombre().equals("BANFIELD")) escudo.setImageResource(R.drawable.escudo_banfield);
        else if(equipo.getNombre().equals("BELGRANO")) escudo.setImageResource(R.drawable.escudo_belgrano);
        else if(equipo.getNombre().equals("BOCA JUNIORS")) escudo.setImageResource(R.drawable.escudo_boca);
        else if(equipo.getNombre().equals("ROSARIO CENTRAL")) escudo.setImageResource(R.drawable.escudo_central);
        else if(equipo.getNombre().equals("COLON DE SANTA FE")) escudo.setImageResource(R.drawable.escudo_colon);
        else if(equipo.getNombre().equals("DEFENSA Y JUSTICIA")) escudo.setImageResource(R.drawable.escudo_defensa);
        else if(equipo.getNombre().equals("ESTUDIANTES DE LA PLATA")) escudo.setImageResource(R.drawable.escudo_estudiantes);
        else if(equipo.getNombre().equals("GIMNASIA DE LA PLATA")) escudo.setImageResource(R.drawable.escudo_gimnasia);
        else if(equipo.getNombre().equals("GODOY CRUZ")) escudo.setImageResource(R.drawable.escudo_godoy);
        else if(equipo.getNombre().equals("HURACAN")) escudo.setImageResource(R.drawable.escudo_huracan);
        else if(equipo.getNombre().equals("INDEPENDIENTE")) escudo.setImageResource(R.drawable.escudo_independiente);
        else if(equipo.getNombre().equals("LANUS")) escudo.setImageResource(R.drawable.escudo_lanus);
        else if(equipo.getNombre().equals("NEWELLS OLD BOYS")) escudo.setImageResource(R.drawable.escudo_newells);
        else if(equipo.getNombre().equals("RACING CLUB")) escudo.setImageResource(R.drawable.escudo_racing);
        else if(equipo.getNombre().equals("RIVER PLATE")) escudo.setImageResource(R.drawable.escudo_river);
        else if(equipo.getNombre().equals("SAN LORENZO")) escudo.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(equipo.getNombre().equals("UNION DE SANTA FE")) escudo.setImageResource(R.drawable.escudo_union);
        else if(equipo.getNombre().equals("VELEZ")) escudo.setImageResource(R.drawable.escudo_velez);
    }

}
