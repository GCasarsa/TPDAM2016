package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTarjetaA;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTarjetaR;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 23/01/2017.
 */
public class TabTarjetas extends Fragment  {
        private static FirebaseDatabase database = FirebaseDatabase.getInstance();
        private static DatabaseReference posicionBD;
        ListView listaTarjetas;
        AdapterTarjetaA adapterAmarilla;
        AdapterTarjetaR adapterRojas;
        ArrayList<Jugador> listaJugadores;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            final View rootView = inflater.inflate(R.layout.tab_tarjetas, container, false);
            listaJugadores = new ArrayList<>();
            posicionBD = database.getReference("jugadores");

            final Switch botonSwitch = (Switch) rootView.findViewById(R.id.SwitchTarjetas);

            botonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (botonSwitch.isChecked()){
                            //TARJETAS ROJAS
                            Query myTopPostsQuery = database.getReference("jugadores").orderByChild("Rojas");
                            myTopPostsQuery.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();

                                Jugador jugador = new Jugador(newPost.get("ApellidoNombre").toString(), (long) newPost.get("goles"), (long) newPost.get("Amarillas"), (long) newPost.get("Rojas"), (String) newPost.get("equipoID"));
                                listaJugadores.add(jugador);

                                ArrayList<Jugador> listaOrdenada = new ArrayList<Jugador>();
                                for (int i = listaJugadores.size() - 1; i >= 0; i--)
                                    if(listaJugadores.get(i).getRojas()>0)
                                        listaOrdenada.add(listaJugadores.get(i));


                                listaTarjetas = (ListView) rootView.findViewById(R.id.listViewTarjetas);
                                adapterRojas = new AdapterTarjetaR(getActivity(),listaOrdenada);
                                listaTarjetas.setAdapter(adapterRojas);

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
                            listaJugadores.clear();
                        }
                        else{
                            //TARJETAS AMARILLAS
                            Query myTopPostsQuery = database.getReference("jugadores").orderByChild("Amarillas");
                            myTopPostsQuery.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();

                                Jugador jugador = new Jugador(newPost.get("ApellidoNombre").toString(), (long) newPost.get("goles"), (long) newPost.get("Amarillas"), (long) newPost.get("Rojas"), (String) newPost.get("equipoID"));
                                listaJugadores.add(jugador);

                                ArrayList<Jugador> listaOrdenada = new ArrayList<Jugador>();
                                for (int i = listaJugadores.size() - 1; i >= 0; i--)
                                    if(listaJugadores.get(i).getAmarillas()>0)
                                        listaOrdenada.add(listaJugadores.get(i));

                                listaTarjetas = (ListView) rootView.findViewById(R.id.listViewTarjetas);
                                adapterAmarilla = new AdapterTarjetaA(getActivity(),listaOrdenada);
                                listaTarjetas.setAdapter(adapterAmarilla);
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
                        listaJugadores.clear();
                        }
            }

            });

            return rootView;
            }
        }