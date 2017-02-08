package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 08/02/2017.
 */

public class AdapterDetalle extends ArrayAdapter<Jugador> {
    LayoutInflater inflater;

    public AdapterDetalle(Context context, List<Jugador> items) {
        super(context, R.layout.layout_fila_jugador, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_jugador, parent, false);
        TextView posicion = (TextView) row.findViewById(R.id.tvEquipoDetallePosicion);
        posicion.setText(getItem(position).getPosicion());
        TextView apellido = (TextView) row.findViewById(R.id.tvEquipoDetalleApellido);
        apellido.setText(getItem(position).getApellido() + " " + getItem(position).getNombre());
        return(row);
    }
}
