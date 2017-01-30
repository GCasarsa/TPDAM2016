package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class EquipoTabUbicacion  extends Fragment implements OnMapReadyCallback {
    private Bundle extras;
    private GoogleMap mapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_ubicacion, container, false);
        extras = getActivity().getIntent().getExtras();
        String id = String.valueOf(extras.getLong("equipo"));

        //SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        return rootView;
    }

    public static EquipoTabUbicacion newInstance(int pagina, String titulo) {
        EquipoTabUbicacion fragmento = new EquipoTabUbicacion();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        fragmento.setArguments(args);
        return fragmento;
    }

    @Override public void onMapReady(GoogleMap googleMap){
        mapa= googleMap;
        LatLng cancha = new LatLng(-34.670314, -58.371010);
        mapa.addMarker(new MarkerOptions().position(cancha).title("Libertadores de América"));
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(cancha,16));
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);

    }

}
