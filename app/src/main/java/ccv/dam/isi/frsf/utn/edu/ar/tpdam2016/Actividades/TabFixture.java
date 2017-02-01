package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterPartido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 18/01/2017.
 */
public class TabFixture extends Fragment{

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    private ArrayAdapter<String> listAdapter1;
    ListView listaPartidos;
    AdapterPartido adapter;
    ArrayList<Partido> partidos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab_fixture, container, false);
        listaPartidos = (ListView) rootView.findViewById(R.id.listaPartidos);
        partidos = new ArrayList<>();
        adapter = new AdapterPartido(getActivity(), partidos);
        listaPartidos.setAdapter(adapter);

        final Spinner spinnerFechas = (Spinner) rootView.findViewById(R.id.spinnerFechas);
        final String[] fechas = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayList<String> arregloFechas = new ArrayList<>();
        arregloFechas.addAll(Arrays.asList(fechas));
        listAdapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arregloFechas);
        listAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFechas.setAdapter(listAdapter1);

        spinnerFechas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Creo y Ejecuto la tarea asincrónica que consulta los partidos de una fecha;
                new BuscarPorFechaAsyncTask().execute(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }

    /**
     * Tarea asincronica que consulta los partidos de una determinada fecha y los setea en el adaptador de la lista de partidos
     * de una fecha
     * @param: Integer, numero de fecha consultada
     */

    private class BuscarPorFechaAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        ProgressDialog dialog = new ProgressDialog(getActivity());

        public BuscarPorFechaAsyncTask(){

        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(getActivity(), "Recopilando partidos", "aguarde unos instantes...");
            dialog.setCanceledOnTouchOutside(true);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Integer... fecha) {

            final int fechaConsultada =  fecha[0]+1;
            partidos.clear();

            posicionBD = database.getReference("bd/partidos");
            posicionBD.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                    Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                    if (Integer.parseInt(newPost.get("fecha").toString()) == fechaConsultada) {
                        Partido partido = new Partido(newPost.get("id").toString(),newPost.get("equipoLocal").toString(),
                                newPost.get("equipoVisitante").toString(), newPost.get("resultadoLocal").toString(),
                                newPost.get("resultadoVisitante").toString(), newPost.get("arbitro").toString(),
                                newPost.get("dia").toString(), newPost.get("fecha").toString(), newPost.get("estadio").toString());
                        partidos.add(partido);
                        adapter.notifyDataSetChanged();
                    }
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
            return partidos.size();

        }

        @Override
        protected void onPostExecute(Integer r) {
            if(dialog.isShowing()) dialog.dismiss();
            adapter.notifyDataSetChanged();
        }
    }



}
