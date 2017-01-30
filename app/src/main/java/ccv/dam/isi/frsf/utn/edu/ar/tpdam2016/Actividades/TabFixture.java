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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterPartido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 18/01/2017.
 */
public class TabFixture extends Fragment{

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

        final Spinner spinnerFechas = (Spinner) rootView.findViewById(R.id.spinnerFechas);
        final String[] fechas = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayList<String> arregloFechas = new ArrayList<>();
        arregloFechas.addAll(Arrays.asList(fechas));
        listAdapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arregloFechas);
        listAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFechas.setAdapter(listAdapter1);

        new BuscarPorFechaAsyncTask().execute(0);

        spinnerFechas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Creo y Ejecuto la tarea asincrónica que consulta los partidos de una fecha;
                new BuscarPorFechaAsyncTask().execute(position+1);

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
            dialog.setMessage(String.valueOf(values[0]));
        }

        @Override
        protected Integer doInBackground(Integer... fecha) {

            partidos.clear();
            int fechaConsultada = fecha[0];
            Conexion.buscarPartidosPorFecha(partidos,fechaConsultada);

            return 1;

        }

        //@Override
        protected void onPostExecute(Integer r) {

            adapter = new AdapterPartido(getActivity(), partidos);
            listaPartidos.setAdapter(adapter);
            if (dialog.isShowing()) dialog.dismiss();

        }
    }




}