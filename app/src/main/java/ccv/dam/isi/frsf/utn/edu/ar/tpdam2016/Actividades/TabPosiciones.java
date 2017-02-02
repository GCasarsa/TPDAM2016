package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterPartido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterPosicion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.FilaPosicion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 23/01/2017.
 */
public class TabPosiciones extends Fragment {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    ListView lvPosiciones;
    AdapterPosicion adapterPos;
    ArrayList<FilaPosicion> posiciones;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab_posiciones, container, false);
        ArrayList<FilaPosicion> listaFechas = new ArrayList<FilaPosicion>();
        //ArrayList posicionesLista = new ArrayList();

            lvPosiciones = (ListView) rootView.findViewById(R.id.listViewPosiciones);
            posiciones = new ArrayList<>();
            adapterPos = new AdapterPosicion(getActivity(), posiciones);
            lvPosiciones.setAdapter(adapterPos);



        //partidos.clear();

        posicionBD = database.getReference("POSICIONES");
        Query myTopPostsQuery = database.getReference("POSICIONES").orderByChild("PTS");
        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                    Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                        FilaPosicion filaPosicion = new FilaPosicion(newPost.get("EQUIPO").toString(),newPost.get("PTS").toString(),
                                newPost.get("PJ").toString(), newPost.get("PG").toString(),
                                newPost.get("PE").toString(), newPost.get("PP").toString(),
                                newPost.get("GF").toString(), newPost.get("GC").toString(), newPost.get("DIF").toString(), snapshot.getRef().getKey());
                        posiciones.add(filaPosicion);
                    FilaPosicion aux;
                    for(int i=0;i<posiciones.size()-1;i++)
                        for(int j=i+1;j<posiciones.size();j++)
                            if((posiciones.get(i).getPts().equals(posiciones.get(j).getPts())&&(Integer.parseInt(posiciones.get(i).getDif())<Integer.parseInt(posiciones.get(i).getDif())))){
                                //intercambiar
                                aux=posiciones.get(i);
                                posiciones.add(i,posiciones.get(j));
                                posiciones.add(j,aux);

                            }



                    ArrayList<FilaPosicion> listaOrdenada = new ArrayList<FilaPosicion>();

                    //fila_Posicion creada para el scroll horizontal de la tabla Final
                    FilaPosicion filaTitulo = new FilaPosicion("POSICION    ","Pts ", " J ","G ","E ", "P ", "Gf/", "c", "D", "#");
                    listaOrdenada.add(filaTitulo);

                    for(int i=posiciones.size()-1;i>=0;i--)
                        listaOrdenada.add(posiciones.get(i));



                    adapterPos = new AdapterPosicion(getActivity(), listaOrdenada);
                    lvPosiciones.setAdapter(adapterPos);

                        adapterPos.notifyDataSetChanged();

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            //return partidos.size();

        return rootView;

    }
}
