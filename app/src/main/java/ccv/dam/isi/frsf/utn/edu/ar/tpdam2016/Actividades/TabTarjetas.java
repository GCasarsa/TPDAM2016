package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Administrador on 23/01/2017.
 */
public class TabTarjetas extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_tarjetas, container, false);

        Button cargarEquipos = (Button) rootView.findViewById(R.id.buttonCargarEquipos);

        cargarEquipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexion.cargarEquipos();
                Conexion.cargarPartidos();
            }
        });
        return rootView;

    }
}
