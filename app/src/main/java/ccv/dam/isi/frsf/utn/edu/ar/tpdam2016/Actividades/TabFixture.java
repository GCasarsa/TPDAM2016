package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

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
        listaPartidos = (ListView)  rootView.findViewById(R.id.listaPartidos);
        partidos = new ArrayList<>();
        //Conexion.buscarPartidos(partidos);

        final Spinner spinnerFechas = (Spinner) rootView.findViewById(R.id.spinnerFechas);
        final String[] fechas = new String[] {"1", "2", "3", "4","5","6"};
        ArrayList<String> arregloFechas = new ArrayList<>();
        arregloFechas.addAll(Arrays.asList(fechas));
        listAdapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,arregloFechas);
        listAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFechas.setAdapter(listAdapter1);
        adapter= new AdapterPartido(getActivity(), partidos); //getActivity() or getContext()
        listaPartidos.setAdapter(adapter);

        spinnerFechas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // partidos.clear(); Cuando este la tarea asyncronica, sacar comentario.
                Conexion.buscarPartidosPorFecha(partidos,Integer.parseInt(spinnerFechas.getItemAtPosition(position).toString()));

                adapter.notifyDataSetChanged();
                rootView.refreshDrawableState();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }


}