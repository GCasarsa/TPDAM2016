package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Administrador on 18/01/2017.
 */
public class AdapterPartido extends ArrayAdapter<Partido> {
    LayoutInflater inflater;
    ImageView escudoL, escudoV;

    public AdapterPartido(Context context, List<Partido> items) {
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
        if(getItem(position).getResultadoLocal().toString().equals("")){
            resultado.setText("-");
        }
        else{
            resultado.setText(getItem(position).getResultadoLocal().toString()+":"+getItem(position).getResultadoVisitante().toString());
        }

        final ImageView verDetalle =(ImageView) row.findViewById(R.id.imageViewEscudoLocal);
        TextView arbitro = (TextView) row.findViewById(R.id.textViewArbitro);
        arbitro.setText("Árbitro: " + getItem(position).getArbitro().toString());
        TextView dia = (TextView) row.findViewById(R.id.textViewDia);
        dia.setText("Día: " + getItem(position).getDia().toString());
        TextView lugar = (TextView) row.findViewById(R.id.textViewLugar);
        lugar.setText(getItem(position).getLugar().toString());
        escudoL = (ImageView) row.findViewById(R.id.imageViewEscudoLocal);
        escudoL.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipoLocal().toString()));
        escudoV = (ImageView) row.findViewById(R.id.imageViewEscudoVisita);
        escudoV.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipoVisitante().toString()));

        nombreLocal.setTypeface(null, Typeface.BOLD);
        nombreVisita.setTypeface(null, Typeface.BOLD);

        return(row);
    }
}
