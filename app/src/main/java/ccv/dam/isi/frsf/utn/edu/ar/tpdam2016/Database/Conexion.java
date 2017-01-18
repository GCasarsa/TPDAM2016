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

    public static void cargarEquipos(){

        posicionBD = database.getReference("bd");
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Aldosivi","R.drawable.escudos.aldosivi"));
        listaEquipos.add(new Equipo("Arsenal","R.drawable.escudos.arsenal"));
        listaEquipos.add(new Equipo("Banfield","R.drawable.escudos.banfield"));
        listaEquipos.add(new Equipo("Belgrano","R.drawable.escudos.belgrano"));
        listaEquipos.add(new Equipo("Boca","R.drawable.escudos.boca"));
        listaEquipos.add(new Equipo("Central","R.drawable.escudos.central"));
        listaEquipos.add(new Equipo("Colon","R.drawable.escudos.colon"));
        listaEquipos.add(new Equipo("Defensa","R.drawable.escudos.defensa"));
        listaEquipos.add(new Equipo("Estudiantes","R.drawable.escudos.estudiantes"));
        listaEquipos.add(new Equipo("Gimnasia de la Plata","R.drawable.escudos.gimnasia"));
        listaEquipos.add(new Equipo("Godoy Cruz","R.drawable.escudos.godoy"));
        listaEquipos.add(new Equipo("Huracan","R.drawable.escudos.huracan"));
        listaEquipos.add(new Equipo("Independiente","R.drawable.escudos.independiente"));
        listaEquipos.add(new Equipo("Lanus","R.drawable.escudos.lanus"));
        listaEquipos.add(new Equipo("Newells","R.drawable.escudos.newells"));
        listaEquipos.add(new Equipo("River","R.drawable.escudos.river"));
        listaEquipos.add(new Equipo("San Lorenzo","R.drawable.escudos.sanlorenzo"));

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
