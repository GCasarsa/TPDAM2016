package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import android.os.AsyncTask;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;


public class BusquedaEquipo extends AsyncTask<String,Integer,ArrayList<Equipo>> {

    private BusquedaFinalizadaListener<Equipo> listener;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ArrayList<Equipo> listaEquipos = new ArrayList<>();

    public BusquedaEquipo(BusquedaFinalizadaListener<Equipo> dListener){
        this.listener = dListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Equipo> equipos) {
        listener.busquedaFinalizada(listaEquipos);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
    }

    @Override
    protected ArrayList<Equipo> doInBackground(String... nombreEquipo) {
        if(nombreEquipo[0].equals("todos")) listaEquipos = buscarEquipos();
        else listaEquipos = buscarEquipo(nombreEquipo[0]);
        return listaEquipos;
    }

    public ArrayList<Equipo> buscarEquipos(){
        posicionBD = database.getReference("datos/equipos/primeradivision");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Equipo equipo = new Equipo(newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
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
        return listaEquipos;
    }

    public ArrayList<Equipo> buscarEquipo(final String idEquipo){
        posicionBD = database.getReference("datos/equipos/primeradivision");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id").equals(idEquipo)){
                    listaEquipos.add(new Equipo(newPost.get("nombre").toString(),
                            newPost.get("abreviatura").toString(),
                            newPost.get("escudo").toString(),
                            newPost.get("division").toString(),
                            newPost.get("ciudad").toString(),
                            newPost.get("foto").toString(),
                            Double.parseDouble(newPost.get("latitud").toString()),
                            Double.parseDouble(newPost.get("longitud").toString()),
                            newPost.get("descripcion").toString(),
                            newPost.get("dt").toString()));
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
        while(listaEquipos.isEmpty()){
        }
        return listaEquipos;
    }
}
