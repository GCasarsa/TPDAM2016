package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterGoleador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaJugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 18/01/2017.
 */
public class TabGoleadores extends Fragment implements BusquedaFinalizadaListener<Jugador>{

    ProgressDialog progressDialog;
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
        listaGoleadores = (ListView) rootView.findViewById(R.id.listaGoleadores);
        listaJugadores = new ArrayList<>();

        progressDialog = ProgressDialog.show(rootView.getContext(), "Recopilando Información", "Aguarde unos instantes...");
        new BusquedaJugador(this).execute("goles");
        return rootView;
    }
    @Override
    public void busquedaFinalizada(ArrayList<Jugador> lista) {
        listaJugadores = lista;
        progressDialog.dismiss();
        ArrayList<Jugador> listaOrdenada = new ArrayList<Jugador>();
        for(int i=listaJugadores.size()-1;i>=0;i--)
            if(listaJugadores.get(i).getGoles()>0)
                listaOrdenada.add(listaJugadores.get(i));
        adapterGoleador = new AdapterGoleador(getActivity(),listaOrdenada);
        listaGoleadores.setAdapter(adapterGoleador);
    }
}