package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 30/01/2017.
 */
public class AdapterResultado extends ArrayAdapter<Partido> {
    LayoutInflater inflater;

    public AdapterResultado(Context context, List<Partido> items) {
        super(context, R.layout.layout_fila_resultado, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_resultado, parent, false);
        TextView fecha = (TextView) row.findViewById(R.id.tvEquiposResultadoFecha);
        fecha.setText(getItem(position).getDia().toString());
        TextView nombreLocal = (TextView) row.findViewById(R.id.tvEquiposResultadoNombreLocal);
        nombreLocal.setText(getItem(position).getEquipoLocal().toString());
        TextView nombreVisita = (TextView) row.findViewById(R.id.tvEquiposResultadoNombreVisitante);
        nombreVisita.setText(getItem(position).getEquipoVisitante().toString());
        TextView golesLocal = (TextView) row.findViewById(R.id.tvEquiposResultadoGolesLocal);
        golesLocal.setText(getItem(position).getResultadoLocal().toString()+":");
        TextView golesVisitante = (TextView) row.findViewById(R.id.tvEquiposResultadoGolesVisitante);
        golesVisitante.setText(getItem(position).getResultadoVisitante().toString());

        return(row);
    }
}
