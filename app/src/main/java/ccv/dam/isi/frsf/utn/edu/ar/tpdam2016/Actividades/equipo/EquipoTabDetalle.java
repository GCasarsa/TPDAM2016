package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaJugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class EquipoTabDetalle extends Fragment implements BusquedaFinalizadaListener<Jugador> {

    private static Equipo equipo;
    ImageView fotoPlantilla;
    ListView listaJugadores;
    ArrayList<Jugador> jugadores;
    TextView dt;
    AdapterDetalle adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_detalle, container, false);
        fotoPlantilla = (ImageView) rootView.findViewById(R.id.ivEquipoDetalleFoto);
        listaJugadores = (ListView) rootView.findViewById(R.id.lvEquipoDetalle);
        dt = (TextView) rootView.findViewById(R.id.tvEquipoDetalleDT);
        busqueda(equipo.getNombre());
        return rootView;
    }

    public static EquipoTabDetalle newInstance(int pagina, String titulo, Equipo equipoRecibido) {
        EquipoTabDetalle fragmentFirst = new EquipoTabDetalle();
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
            listaJugadores.setAdapter(adapter);
            fotoPlantilla.setImageResource(CargarEscudos.cargarPortada(equipo.getNombre()));
        }
        dt.setText(equipo.getDirectorTecnico());
    }

}
