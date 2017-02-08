package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import android.os.AsyncTask;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Gabriel on 06/02/2017.
 */

public class BusquedaJugador  extends AsyncTask<String,Integer,ArrayList<Jugador>> {

    private BusquedaFinalizadaListener<Jugador> listener;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public BusquedaJugador(BusquedaFinalizadaListener<Jugador> dListener){
        this.listener = dListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Jugador> jugadores) {
        listener.busquedaFinalizada(listaJugadores);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
    }

    @Override
    protected ArrayList<Jugador> doInBackground(String... tipoConsulta) {
        if(tipoConsulta[0].equals("goles"))
            listaJugadores = buscarJugadores(database.getReference("jugadores").orderByChild("goles"));
        else if(tipoConsulta[0].equals("amarillas"))
            listaJugadores = buscarJugadores(database.getReference("jugadores").orderByChild("Amarillas"));
        else if(tipoConsulta[0].equals("rojas"))
            listaJugadores = buscarJugadores(database.getReference("jugadores").orderByChild("Rojas"));
        return listaJugadores;
    }

    public ArrayList<Jugador> buscarJugadores(Query consulta){
        posicionBD = database.getReference("datos/jugadores");

        consulta.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                listaJugadores.add(new Jugador(newPost.get("id").toString(),
                        newPost.get("nombre").toString(),
                        newPost.get("apellido").toString(),
                        newPost.get("posicion").toString(),
                        newPost.get("equipo").toString(),
                        newPost.get("titular").toString(),
                        Integer.parseInt(newPost.get("goles").toString()),
                        Integer.parseInt(newPost.get("amarillas").toString()),
                        Integer.parseInt(newPost.get("rojas").toString()),
                        Integer.parseInt(newPost.get("partidosJugados").toString())
                ));
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
        while(listaJugadores.isEmpty()){
        }
        return listaJugadores;
    }

}