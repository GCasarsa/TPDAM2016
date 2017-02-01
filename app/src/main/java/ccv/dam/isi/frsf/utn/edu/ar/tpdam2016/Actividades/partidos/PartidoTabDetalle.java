package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.partidos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class PartidoTabDetalle extends Fragment {

    private static Partido partido;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_partido_tab_detalle, container, false);

        return rootView;
    }

    public static PartidoTabDetalle newInstance(int pagina, String titulo, Partido partidoRecibido) {
        PartidoTabDetalle fragmentFirst = new PartidoTabDetalle();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        partido = partidoRecibido;
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
}
