package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaJugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;


public class EquipoTabPlantilla extends Fragment implements BusquedaFinalizadaListener<Jugador> {

    ListView listaJugadores;
    ArrayList<Jugador> jugadores;
    AdapterDetalle adapter;
    private static Equipo equipo;


    public EquipoTabPlantilla() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_plantilla, container, false);
        listaJugadores = (ListView) rootView.findViewById(R.id.listViewPlantilla);
        busqueda(equipo.getNombre());


        return rootView;
    }


    public static EquipoTabPlantilla newInstance(int pagina, String titulo, Equipo equipoRecibido) {
        EquipoTabPlantilla fragmentFirst = new EquipoTabPlantilla();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        equipo = equipoRecibido;
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    public void busqueda(String nombreEquipo){
        new BusquedaJugador(this).execute(nombreEquipo);
    }

    @Override
    public void busquedaFinalizada(ArrayList<Jugador> lista) {
        if(!lista.isEmpty()){
            jugadores = lista;
            adapter= new AdapterDetalle(getActivity(), jugadores);
            listaJugadores.setOnItemClickListener(null);
            listaJugadores.setAdapter(adapter);
        }
    }
}
