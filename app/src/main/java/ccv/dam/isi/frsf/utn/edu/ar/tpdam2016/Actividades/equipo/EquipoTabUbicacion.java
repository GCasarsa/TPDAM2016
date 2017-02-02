package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class EquipoTabUbicacion  extends Fragment implements OnMapReadyCallback {
    private GoogleMap mapa;
    private static Equipo equipo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_ubicacion, container, false);
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        return rootView;
    }

    public static EquipoTabUbicacion newInstance(int pagina, String titulo, Equipo equipoRecibido) {
        EquipoTabUbicacion fragmento = new EquipoTabUbicacion();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        equipo = equipoRecibido;
        fragmento.setArguments(args);
        return fragmento;
    }

    @Override public void onMapReady(GoogleMap googleMap){
        if(ActivityCompat.checkSelfPermission(getActivity(),android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},9999);
            return;
        }
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mapa= googleMap;
        mapa.setMyLocationEnabled(true);
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        float[] resultado = new float[1];
        MarkerOptions marcador = new MarkerOptions().position(new LatLng(equipo.getLatitud(), equipo.getLongitud())).title(equipo.getDescripcionEstadio());
        android.location.Location.distanceBetween(marcador.getPosition().latitude, marcador.getPosition().longitude, location.getLatitude(), location.getLongitude(), resultado);
        marcador.title(equipo.getDescripcionEstadio());
        marcador.snippet("Distancia: " + Math.round(resultado[0]/1000)  +"Km");
        mapa.addMarker(marcador);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(equipo.getLatitud(), equipo.getLongitud()),16));
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
    }

}
