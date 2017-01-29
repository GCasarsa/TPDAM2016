package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

public class Conexion {
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
                Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
                listaEquipos.add(equipo);
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

    public static void buscarEquipo(final String idEquipo){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id") == idEquipo){
                    Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
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

    public static void buscarPartidosPorFecha(final ArrayList<Partido> listaPartidos, final int fecha){
        posicionBD = database.getReference("partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                //System.out.println("FECHA 1: " + fecha + " - FECHA 2: "+Integer.parseInt(newPost.get("jornadaTorneo").toString()));
                if(Integer.parseInt(newPost.get("jornadaTorneo").toString())==fecha) {
                    Partido partido = new Partido(newPost.get("equipoLocal").toString(), newPost.get("equipoVisitante").toString(), newPost.get("marcadorLocal").toString(), newPost.get("marcadorVisitante").toString(), newPost.get("arbitro").toString(), newPost.get("fechaCronologica").toString(), newPost.get("jornadaTorneo").toString(), newPost.get("estadio").toString());
                    listaPartidos.add(partido);
                }
                //System.out.println("PARTIDOS: " + listaPartidos.size());
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
        listaEquipos.add(new Equipo("1","Aldosivi","aldosivi.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("2","Arsenal","arsenal.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("3","Banfield","banfield.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("4","Belgrano","belgrano.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("5","Boca","boca.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("6","Central","central.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("7","Colon","colon.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("8","Defensa","defensa.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("9","Estudiantes","estudiantes.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("10","Gimnasia de la Plata","gimnasia.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("11","Godoy Cruz","godoy.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("12","Huracan","huracan.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("13","Independiente","independiente.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("14","Lanus","lanus.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("15","Newells","newells.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("16","River","river.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("17","San Lorenzo","sanlorenzo.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("18","Union","union.png","PRIMERA DIVISIÓN"));
        listaEquipos.add(new Equipo("19","Velez","velez.png","PRIMERA DIVISIÓN"));

        for(int i = 0; i < listaEquipos.size(); i++){

            //String key = posicionBD.child("posts").push().getKey();
            Map<String, Object> postValues = toMap(listaEquipos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/equipos/" + listaEquipos.get((i)).getId(), postValues);

            posicionBD.updateChildren(childUpdates);
        }
    }

    public static Map<String, Object> toMap(Equipo equipo) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", equipo.getId());
        result.put("nombre", equipo.getNombre().toUpperCase());
        result.put("escudo", equipo.getEscudo());
        result.put("division",equipo.getDivision());
        return result;
    }

}
