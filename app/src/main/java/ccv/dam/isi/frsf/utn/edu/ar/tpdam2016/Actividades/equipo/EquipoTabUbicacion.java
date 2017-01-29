package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class EquipoTabUbicacion  extends Fragment/* implements OnMapReadyCallback */{
    private Bundle extras;
    private GoogleMap mapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_ubicacion, container, false);
        extras = getActivity().getIntent().getExtras();
        String id = String.valueOf(extras.getLong("equipo"));

        /*SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
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
/*
    @Override public void onMapReady(GoogleMap googleMap){
        mapa= googleMap;
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
    }

    /*private void actualizarMapa() {
        if(ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(rootView,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},9999);
            mapa.setMyLocationEnabled(true);
            return;
        }
        mapa.setMyLocationEnabled(true);
    }*/
}
