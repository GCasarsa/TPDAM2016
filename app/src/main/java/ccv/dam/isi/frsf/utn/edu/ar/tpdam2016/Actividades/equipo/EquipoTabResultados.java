package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */
public class EquipoTabResultados  extends Fragment {
    private Bundle extras;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_resultados, container, false);
        extras = getActivity().getIntent().getExtras();
        String id = String.valueOf(extras.getLong("equipo"));

        return rootView;
    }

    public static EquipoTabResultados newInstance(int pagina, String titulo) {
        EquipoTabResultados fragmento = new EquipoTabResultados();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        fragmento.setArguments(args);
        return fragmento;
    }

}
