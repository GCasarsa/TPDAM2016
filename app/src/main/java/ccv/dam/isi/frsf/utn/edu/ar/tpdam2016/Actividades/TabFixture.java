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
import android.widget.TextView;

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
        View rootView = inflater.inflate(R.layout.tab_fixture, container, false);
        partidos = new ArrayList<>();
        //Conexion.buscarPartidos(partidos);

        Spinner spinerFechas = (Spinner) rootView.findViewById(R.id.spinnerFechas);
        final String[] fechas = new String[] {"1", "2", "3", "4","5","6"};
        ArrayList<String> arregloFechas = new ArrayList<String>();
        arregloFechas.addAll(Arrays.asList(fechas));
        listAdapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,arregloFechas);
        listAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerFechas.setAdapter(listAdapter1 );


        /*spinerFechas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });*/

        //int fecha= Integer.parseInt(spinerFechas.getSelectedItem().toString());
        Conexion.buscarPartidosPorFecha(partidos,Integer.parseInt(spinerFechas.getSelectedItem().toString()));

        listaPartidos = (ListView)  rootView.findViewById(R.id.listaPartidos);
        adapter= new AdapterPartido(getActivity(), partidos); //getActivity() or getContext()
        listaPartidos.setAdapter(adapter);

        return rootView;
    }


}