package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Administrador on 18/01/2017.
 */
public class Tab1 extends Fragment{
    ListView listaPartidos;
    AdapterPartido adapter;
    ArrayList<Partido> partidos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        partidos = new ArrayList<>();
        partidos.add(new Partido("River","3 - 0", "Boca","Fecha: 5"));
        partidos.add(new Partido("Huracan","1 - 4", "San Lorenzo","Fecha: 5"));
        partidos.add(new Partido("Colon","3 - 2", "Union","Fecha: 5"));
        listaPartidos = (ListView)  rootView.findViewById(R.id.listaPartidos);
        adapter= new AdapterPartido(getContext(), partidos);
        listaPartidos.setAdapter(adapter);
        return inflater.inflate(R.layout.tab1, container, false);
    }
}