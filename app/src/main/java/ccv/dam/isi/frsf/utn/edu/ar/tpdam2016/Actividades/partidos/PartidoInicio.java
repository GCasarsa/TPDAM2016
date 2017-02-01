package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.partidos;

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

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.AdapterTabs;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 01/02/2017.
 */
public class PartidoInicio extends FragmentActivity {

    private static ImageView atras, escudoL, escudoV;
    private static TextView titulo, nombreLocal, nombreVisita, resultado;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    private static Partido partido;
    private static Equipo equipoLocal, equipoVisitante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = String.valueOf(getIntent().getExtras().getLong("partido"));
        buscarPartido(id);

        setContentView(R.layout.activity_partido);
        escudoL = (ImageView) findViewById(R.id.ivPartidoEscudoLocal);
        escudoV = (ImageView) findViewById(R.id.ivPartidoEscudoVisitante);
        nombreLocal = (TextView) findViewById(R.id.tvPartidoNombreLocal);
        nombreVisita = (TextView) findViewById(R.id.tvPartidoNombreVisitante);
        resultado = (TextView) findViewById(R.id.tvPartidoResultado);

        titulo = (TextView) findViewById(R.id.tvPartidoTitulo);
        atras = (ImageView) findViewById(R.id.ivPartidoAtras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });

    }

    public void buscarPartido(final String idPartido){
        posicionBD = database.getReference("bd/partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id").equals(idPartido)){
                    partido = new Partido(newPost.get("id").toString(),
                            newPost.get("equipoLocal").toString(),
                            newPost.get("equipoVisitante").toString(),
                            newPost.get("resultadoLocal").toString(),
                            newPost.get("resultadoVisitante").toString(),
                            newPost.get("arbitro").toString(),
                            newPost.get("dia").toString(),
                            newPost.get("fecha").toString(),
                            newPost.get("estadio").toString());

                    nombreLocal.setText(partido.getEquipoLocal());
                    nombreVisita.setText(partido.getEquipoVisitante());
                    titulo.setText(partido.getEquipoLocal() + " - " + partido.getEquipoVisitante());
                    resultado.setText(partido.getResultadoLocal() + "    "+ partido.getResultadoVisitante());
                    agregarEscudoL(partido.getEquipoLocal());
                    agregarEscudoV(partido.getEquipoVisitante());

                    AdapterTabsPartido adapterTabs;
                    ViewPager mViewPager;
                    adapterTabs = new AdapterTabsPartido(getSupportFragmentManager(), partido);
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
    public void agregarEscudoL(String local){
        if(local.equals("ALDOSIVI")) escudoL.setImageResource(R.drawable.escudo_aldosivi);
        else if(local.equals("ARSENAL DE SARANDÍ")) escudoL.setImageResource(R.drawable.escudo_arsenal);
        else if(local.equals("BANFIELD")) escudoL.setImageResource(R.drawable.escudo_banfield);
        else if(local.equals("BELGRANO")) escudoL.setImageResource(R.drawable.escudo_belgrano);
        else if(local.equals("BOCA JUNIORS")) escudoL.setImageResource(R.drawable.escudo_boca);
        else if(local.equals("ROSARIO CENTRAL")) escudoL.setImageResource(R.drawable.escudo_central);
        else if(local.equals("COLON DE SANTA FE")) escudoL.setImageResource(R.drawable.escudo_colon);
        else if(local.equals("DEFENSA Y JUSTICIA")) escudoL.setImageResource(R.drawable.escudo_defensa);
        else if(local.equals("ESTUDIANTES")) escudoL.setImageResource(R.drawable.escudo_estudiantes);
        else if(local.equals("GIMNASIA DE LA PLATA")) escudoL.setImageResource(R.drawable.escudo_gimnasia);
        else if(local.equals("GODOY CRUZ")) escudoL.setImageResource(R.drawable.escudo_godoy);
        else if(local.equals("HURACAN")) escudoL.setImageResource(R.drawable.escudo_huracan);
        else if(local.equals("INDEPENDIENTE")) escudoL.setImageResource(R.drawable.escudo_independiente);
        else if(local.equals("LANUS")) escudoL.setImageResource(R.drawable.escudo_lanus);
        else if(local.equals("NEWELLS OLD BOYS")) escudoL.setImageResource(R.drawable.escudo_newells);
        else if(local.equals("RACING CLUB")) escudoL.setImageResource(R.drawable.escudo_racing);
        else if(local.equals("RIVER PLATE")) escudoL.setImageResource(R.drawable.escudo_river);
        else if(local.equals("SAN LORENZO")) escudoL.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(local.equals("UNION DE SANTA FE")) escudoL.setImageResource(R.drawable.escudo_union);
        else if(local.equals("VELEZ")) escudoL.setImageResource(R.drawable.escudo_velez);
    }
    public void agregarEscudoV(String visitante){
        if(visitante.equals("ALDOSIVI")) escudoV.setImageResource(R.drawable.escudo_aldosivi);
        else if(visitante.equals("ARSENAL DE SARANDÍ")) escudoV.setImageResource(R.drawable.escudo_arsenal);
        else if(visitante.equals("BANFIELD")) escudoV.setImageResource(R.drawable.escudo_banfield);
        else if(visitante.equals("BELGRANO")) escudoV.setImageResource(R.drawable.escudo_belgrano);
        else if(visitante.equals("BOCA JUNIORS")) escudoV.setImageResource(R.drawable.escudo_boca);
        else if(visitante.equals("ROSARIO CENTRAL")) escudoV.setImageResource(R.drawable.escudo_central);
        else if(visitante.equals("COLON DE SANTA FE")) escudoV.setImageResource(R.drawable.escudo_colon);
        else if(visitante.equals("DEFENSA Y JUSTICIA")) escudoV.setImageResource(R.drawable.escudo_defensa);
        else if(visitante.equals("ESTUDIANTES")) escudoV.setImageResource(R.drawable.escudo_estudiantes);
        else if(visitante.equals("GIMNASIA DE LA PLATA")) escudoV.setImageResource(R.drawable.escudo_gimnasia);
        else if(visitante.equals("GODOY CRUZ")) escudoV.setImageResource(R.drawable.escudo_godoy);
        else if(visitante.equals("HURACAN")) escudoV.setImageResource(R.drawable.escudo_huracan);
        else if(visitante.equals("INDEPENDIENTE")) escudoV.setImageResource(R.drawable.escudo_independiente);
        else if(visitante.equals("LANUS")) escudoV.setImageResource(R.drawable.escudo_lanus);
        else if(visitante.equals("NEWELLS OLD BOYS")) escudoV.setImageResource(R.drawable.escudo_newells);
        else if(visitante.equals("RACING CLUB")) escudoV.setImageResource(R.drawable.escudo_racing);
        else if(visitante.equals("RIVER PLATE")) escudoV.setImageResource(R.drawable.escudo_river);
        else if(visitante.equals("SAN LORENZO")) escudoV.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(visitante.equals("UNION DE SANTA FE")) escudoV.setImageResource(R.drawable.escudo_union);
        else if(visitante.equals("VELEZ")) escudoV.setImageResource(R.drawable.escudo_velez);
    }
}
