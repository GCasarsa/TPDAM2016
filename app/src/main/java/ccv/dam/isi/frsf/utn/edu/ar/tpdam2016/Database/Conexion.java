package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

public class Conexion {
    private static String TAG;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    public Conexion(){

    }

    public static void buscarEquipos(final ArrayList<Equipo> listaEquipos){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Equipo equipo = new Equipo(newPost.get("nombre").toString(), newPost.get("escudo").toString());
                listaEquipos.add(equipo);
                System.out.println(listaEquipos.size());
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

    public static void buscarPartidos(final ArrayList<Partido> listaPartidos){
        posicionBD = database.getReference("partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Partido partido = new Partido(newPost.get("equipoLocal").toString(),newPost.get("equipoVisitante").toString(), newPost.get("marcadorLocal").toString(),newPost.get("marcadorVisitante").toString(),newPost.get("arbitro").toString(),newPost.get("fechaCronologica").toString(),newPost.get("jornadaTorneo").toString(),newPost.get("estadio").toString());
                listaPartidos.add(partido);
                System.out.println(listaPartidos.size());
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

    public static void cargarEquipos(){

        posicionBD = database.getReference("bd");
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Aldosivi","/img/escudos/aldosivi.png"));
        listaEquipos.add(new Equipo("Arsenal","/img/escudos/arsenal.png"));
        listaEquipos.add(new Equipo("Banfield","/img/escudos/banfield.png"));
        listaEquipos.add(new Equipo("Belgrano","/img/escudos/belgrano.png"));
        listaEquipos.add(new Equipo("Boca","/img/escudos/boca.png"));
        listaEquipos.add(new Equipo("Central","/img/escudos/central.png"));
        listaEquipos.add(new Equipo("Colon","/img/escudos/colon.png"));
        listaEquipos.add(new Equipo("Defensa","/img/escudos/defensa.png"));
        listaEquipos.add(new Equipo("Estudiantes","/img/escudos/estudiantes.png"));
        listaEquipos.add(new Equipo("Gimnasia de la Plata","/img/escudos/gimnasia.png"));
        listaEquipos.add(new Equipo("Godoy Cruz","/img/escudos/godoy.png"));
        listaEquipos.add(new Equipo("Huracan","/img/escudos/huracan.png"));
        listaEquipos.add(new Equipo("Independiente","/img/escudos/independiente.png"));
        listaEquipos.add(new Equipo("Lanus","/img/escudos/lanus.png"));
        listaEquipos.add(new Equipo("Newells","/img/escudos/newells.png"));
        listaEquipos.add(new Equipo("River","/img/escudos/river.png"));
        listaEquipos.add(new Equipo("San Lorenzo","/img/escudos/sanlorenzo.png"));

        for(int i = 0; i < listaEquipos.size(); i++){

            String key = posicionBD.child("posts").push().getKey();
            Map<String, Object> postValues = toMap(listaEquipos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/equipos/" + key, postValues);

            posicionBD.updateChildren(childUpdates);
        }
    }

    public static Map<String, Object> toMap(Equipo equipo) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nombre", equipo.getNombre());
        result.put("escudo", equipo.getEscudo());
        return result;
    }

}
