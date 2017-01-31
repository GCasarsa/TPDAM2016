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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

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
    ArrayAdapter adapter;
    ArrayList<Jugador> listaJugadores;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_goleadores, container, false);

        listaJugadores = new ArrayList<Jugador>();
        ArrayList<String> goleadores = new ArrayList<String>();
        //ArrayList<Jugador> listaOrdenada = new ArrayList<Jugador>();

        //Conexion.buscarJugadores(listaJugadores);
        //METODO DE CONEXION COPIADO
        posicionBD = database.getReference("jugadores");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Jugador jugador = new Jugador(newPost.get("ApellidoNombre").toString(),(long)newPost.get("goles"), (long)newPost.get("Amarillas"),(long)newPost.get("Rojas"),(long)newPost.get("equipoID"));
                listaJugadores.add(jugador);
                System.out.println(listaJugadores.size());
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
        //SystemClock.sleep(7000);




        //listaOrdenada = burbuja(listaJugadores);
        System.out.println("tamanioo: "+listaJugadores.size());
        for(int i=0;i<listaJugadores.size();i++)
            goleadores.add(listaJugadores.get(i).getApellido()+" - "+(listaJugadores.get(i)).getGoles()+" goles");
        //goleadores.add("Valinotti - 6 goles");
        //goleadores.add("Casado    - 2 goles");
        listaGoleadores = (ListView)  rootView.findViewById(R.id.listaGoleadores);
        //listaGoleadores.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1 , android.R.id.text1, goleadores);
        listaGoleadores.setAdapter( adapter );
        //System.out.println("tamanioo: "+goleadores.size());


        return rootView;
    }

    public ArrayList<Jugador> burbuja (ArrayList<Jugador> listaJugadores){
        int i, j;
        int indiceIntercambio;
        int n=listaJugadores.size();
        i=n-1;

        while (i>0){
            indiceIntercambio=0;
            for(j=0;j<i;j++)
                if(listaJugadores.get(j+1).getGoles()<listaJugadores.get(j).getGoles()){
                    indiceIntercambio=j;
                    listaJugadores = intercambiar(listaJugadores,j);
                    
                }
            i= indiceIntercambio;
        }

        return listaJugadores;
    }


    private ArrayList<Jugador> intercambiar(ArrayList<Jugador> listaJugadores, int j) {

        { int i=j, k=j+1;
            for (i = 0; i < listaJugadores.size()-1; i++)

                for (k = i+1; k < listaJugadores.size(); k++)
                    if (listaJugadores.get(k).getGoles() > listaJugadores.get(k-1).getGoles() )
                    { intercambiar (listaJugadores, i);
                    }
        }
        return listaJugadores;
    }


}