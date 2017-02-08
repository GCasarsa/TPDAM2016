package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */
public class EquipoTabFixture  extends Fragment {
    private static Equipo equipo;
    ListView listViewPartidos;
    ArrayList<Partido> listaPartidos;
    AdapterFixture adapter;

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_resultados, container, false);
        listViewPartidos = (ListView) rootView.findViewById(R.id.lvEquipoResultado);
        listaPartidos = new ArrayList<>();

        buscarPartidos(listaPartidos,equipo.getNombre());


        return rootView;
    }

    public static EquipoTabFixture newInstance(int pagina, String titulo, Equipo equipoRecibido) {
        EquipoTabFixture fragmento = new EquipoTabFixture();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        equipo = equipoRecibido;
        fragmento.setArguments(args);
        return fragmento;
    }

    public void buscarPartidos(final ArrayList<Partido> listaPartidos, final String nombre){
        posicionBD = database.getReference("datos/partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("equipoLocal").toString().equals(nombre) || newPost.get("equipoVisitante").toString().equals(nombre)) {
                    Partido partido = new Partido(newPost.get("id").toString(),newPost.get("equipoLocal").toString(), newPost.get("equipoVisitante").toString(), newPost.get("resultadoLocal").toString(), newPost.get("resultadoVisitante").toString(), newPost.get("arbitro").toString(), newPost.get("dia").toString(), newPost.get("fecha").toString(), newPost.get("estadio").toString(),newPost.get("partidoDisputado").toString());
                    listaPartidos.add(partido);
                    adapter = new AdapterFixture(getActivity(), listaPartidos, equipo);
                    listViewPartidos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
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


}