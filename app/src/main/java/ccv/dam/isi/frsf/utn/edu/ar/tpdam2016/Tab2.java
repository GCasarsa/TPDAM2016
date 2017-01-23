package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Administrador on 18/01/2017.
 */
public class Tab2 extends Fragment{
    ListView listaGoleadores;
    ArrayAdapter adapter;
    ArrayList goleadores;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2, container, false);
        goleadores = new ArrayList<String>();
        goleadores.add("Casarsa   - 10 goles");
        goleadores.add("Valinotti - 6 goles");
        goleadores.add("Casado    - 2 goles");
        listaGoleadores = (ListView)  rootView.findViewById(R.id.listaGoleadores);
        listaGoleadores.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1 , android.R.id.text1, goleadores);
        listaGoleadores.setAdapter( adapter );

        return rootView;
    }
}