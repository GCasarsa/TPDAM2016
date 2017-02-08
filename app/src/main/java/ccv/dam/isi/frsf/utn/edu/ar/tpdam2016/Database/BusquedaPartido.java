package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import android.os.AsyncTask;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Gabriel on 07/02/2017.
 */

public class BusquedaPartido extends AsyncTask<String,Integer,ArrayList<Partido>> {

    private BusquedaFinalizadaListener<Partido> listener;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ArrayList<Partido> listaPartidos = new ArrayList<>();


    public BusquedaPartido(BusquedaFinalizadaListener<Partido> dListener){
        this.listener = dListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Partido> partidos) {
        listener.busquedaFinalizada(listaPartidos);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
    }

    @Override
    protected ArrayList<Partido> doInBackground(String... nombrePartido) {
        if(nombrePartido[0].equals("todos")) listaPartidos = buscarPartidos();
        if(nombrePartido[0].equals("fecha")) listaPartidos = buscarPartidoPorFecha(nombrePartido[1]);
        else listaPartidos = buscarPartido(nombrePartido[0]);
        return listaPartidos;
    }

    public ArrayList<Partido> buscarPartidos(){
        posicionBD = database.getReference("bd/partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                listaPartidos.add(new Partido(newPost.get("id").toString(),
                        newPost.get("equipoLocal").toString(),
                        newPost.get("equipoVisitante").toString(),
                        newPost.get("resultadoLocal").toString(),
                        newPost.get("resultadoVisitante").toString(),
                        newPost.get("arbitro").toString(),
                        newPost.get("dia").toString(),
                        newPost.get("fecha").toString(),
                        newPost.get("estadio").toString()));
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
        return listaPartidos;
    }

    public ArrayList<Partido> buscarPartido(final String idPartido){
        posicionBD = database.getReference("bd/partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id").equals(idPartido)){
                    listaPartidos.add(new Partido(newPost.get("id").toString(),
                            newPost.get("equipoLocal").toString(),
                            newPost.get("equipoVisitante").toString(),
                            newPost.get("resultadoLocal").toString(),
                            newPost.get("resultadoVisitante").toString(),
                            newPost.get("arbitro").toString(),
                            newPost.get("dia").toString(),
                            newPost.get("fecha").toString(),
                            newPost.get("estadio").toString()));
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
        while(listaPartidos.isEmpty()){
        }
        return listaPartidos;
    }

    public ArrayList<Partido> buscarPartidoPorFecha(final String fecha){
        posicionBD = database.getReference("bd/partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("fecha").equals(fecha)){
                    listaPartidos.add(new Partido(newPost.get("id").toString(),
                            newPost.get("equipoLocal").toString(),
                            newPost.get("equipoVisitante").toString(),
                            newPost.get("resultadoLocal").toString(),
                            newPost.get("resultadoVisitante").toString(),
                            newPost.get("arbitro").toString(),
                            newPost.get("dia").toString(),
                            newPost.get("fecha").toString(),
                            newPost.get("estadio").toString()));
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
        while(listaPartidos.isEmpty()){
        }
        return listaPartidos;
    }
}