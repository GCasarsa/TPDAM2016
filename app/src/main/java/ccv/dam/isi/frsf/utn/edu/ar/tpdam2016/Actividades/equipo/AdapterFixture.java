package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 01/02/2017.
 */
public class AdapterFixture extends ArrayAdapter<Partido> {
    LayoutInflater inflater;
    String equipo;

    public AdapterFixture(Context context, List<Partido> items, String equipo) {
        super(context, R.layout.layout_fila_fixture, items);
        inflater= LayoutInflater.from(context);
        this.equipo = equipo;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_fixture, parent, false);
        TextView fecha = (TextView) row.findViewById(R.id.tvEquiposResultadoFecha);
        fecha.setText(getItem(position).getDia().toString());
        TextView nombreLocal = (TextView) row.findViewById(R.id.tvEquiposResultadoNombreLocal);
        nombreLocal.setText(getItem(position).getEquipoLocal().toString());
        isEnabled(position);
        if(equipo.equals(getItem(position).getEquipoLocal().toString())){
            nombreLocal.setTypeface(null, Typeface.BOLD);
        }
        TextView nombreVisita = (TextView) row.findViewById(R.id.tvEquiposResultadoNombreVisitante);
        nombreVisita.setText(getItem(position).getEquipoVisitante().toString());
        if(equipo.equals(getItem(position).getEquipoVisitante().toString())){
            nombreVisita.setTypeface(null, Typeface.BOLD);
        }
        return(row);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}