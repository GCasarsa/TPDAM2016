package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTarjetaA;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTarjetaR;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaJugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 23/01/2017.
 */
public class TabTarjetas extends Fragment  implements BusquedaFinalizadaListener<Jugador>{
    ListView listaTarjetas;
    AdapterTarjetaA adapterAmarilla;
    AdapterTarjetaR adapterRojas;
    ArrayList<Jugador> listaJugadores;
    ProgressDialog progressDialog;
    Switch botonSwitch;
    String tipo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_tarjetas, container, false);
        listaJugadores = new ArrayList<>();
        botonSwitch = (Switch) rootView.findViewById(R.id.SwitchTarjetas);
        listaTarjetas = (ListView) rootView.findViewById(R.id.listViewTarjetas);
        progressDialog = ProgressDialog.show(rootView.getContext(), "Recopilando Información", "Aguarde unos instantes...");
        tipo = "amarillas";
        new BusquedaJugador(this).execute("amarillas");
        botonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()  {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (botonSwitch.isChecked()) {
                    tipo = "rojas";
                    progressDialog = ProgressDialog.show(rootView.getContext(), "Recopilando Información", "Aguarde unos instantes...");
                    buscar();
                } else {
                    tipo = "amarillas";
                    progressDialog = ProgressDialog.show(rootView.getContext(), "Recopilando Información", "Aguarde unos instantes...");
                    buscar();
                }
            }
        });
        return rootView;
    }
    public void buscar(){
        new BusquedaJugador(this).execute(tipo);
    }
    @Override
    public void busquedaFinalizada(ArrayList<Jugador> lista) {

        listaJugadores = lista;
        progressDialog.dismiss();
        if(tipo.equals("rojas")){
            ArrayList<Jugador> listaOrdenada = new ArrayList<>();
            for (int i = listaJugadores.size() - 1; i >= 0; i--)
                if(listaJugadores.get(i).getRojas()>0)
                    listaOrdenada.add(listaJugadores.get(i));
            adapterRojas = new AdapterTarjetaR(getActivity(),listaOrdenada);
            listaTarjetas.setAdapter(adapterRojas);
        }
        else{
            ArrayList<Jugador> listaOrdenada = new ArrayList<>();
            for (int i = listaJugadores.size() - 1; i >= 0; i--)
                if(listaJugadores.get(i).getAmarillas()>0)
                    listaOrdenada.add(listaJugadores.get(i));
            adapterAmarilla = new AdapterTarjetaA(getActivity(),listaOrdenada);
            listaTarjetas.setAdapter(adapterAmarilla);
        }
    }

}