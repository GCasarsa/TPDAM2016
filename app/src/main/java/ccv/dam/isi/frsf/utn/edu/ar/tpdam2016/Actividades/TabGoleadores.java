package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Vector;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterGoleador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 18/01/2017.
 */
public class TabGoleadores extends Fragment{
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ListView listaGoleadores;
    AdapterGoleador adapterGoleador;
    ArrayList<Jugador> listaJugadores;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab_goleadores, container, false);
        listaJugadores = new ArrayList<Jugador>();

        posicionBD = database.getReference("jugadores");
        Query myTopPostsQuery = database.getReference("jugadores").orderByChild("goles");

        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();

                Jugador jugador = new Jugador(newPost.get("ApellidoNombre").toString(),(long)newPost.get("goles"), (long)newPost.get("Amarillas"),(long)newPost.get("Rojas"),newPost.get("equipoID").toString());
                listaJugadores.add(jugador);

                ArrayList<Jugador> listaOrdenada = new ArrayList<Jugador>();
                for(int i=listaJugadores.size()-1;i>=0;i--)
                    if(listaJugadores.get(i).getGoles()>0)
                        listaOrdenada.add(listaJugadores.get(i));

                listaGoleadores = (ListView)  rootView.findViewById(R.id.listaGoleadores);
                adapterGoleador = new AdapterGoleador(getActivity(),listaOrdenada);
                listaGoleadores.setAdapter(adapterGoleador);

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

        return rootView;
    }

}