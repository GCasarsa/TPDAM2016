package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Administrador on 18/01/2017.
 */
public class AdapterPartido extends ArrayAdapter<Partido> {
    LayoutInflater inflater;

    AdapterPartido(Context context, List<Partido> items) {
        super(context, R.layout.layout_fila_partido, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_partido, parent, false);
        TextView nombreLocal = (TextView) row.findViewById(R.id.textViewNombreLocal);
        nombreLocal.setText(getItem(position).getEquipoLocal().toString());
        TextView nombreVisita = (TextView) row.findViewById(R.id.textViewNombreVisita);
        nombreVisita.setText(getItem(position).getEquipoVisitante().toString());
        TextView resultado = (TextView) row.findViewById(R.id.textViewResultado);
        resultado.setText(getItem(position).getResultado().toString());
        TextView fecha = (TextView) row.findViewById(R.id.textViewFecha);
        fecha.setText(getItem(position).getFecha().toString());
        final ImageView verDetalle =(ImageView) row.findViewById(R.id.imageViewEscudoLocal);
        verDetalle.setImageResource(R.drawable.editar);

        return(row);
    }
}
