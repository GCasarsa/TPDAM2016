package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.FilaPosicion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Administrador on 02/02/2017.
 */

public class AdapterGoleador extends ArrayAdapter<Jugador> {
    LayoutInflater inflater;
    ImageView escudo;


    public AdapterGoleador(Context context, List<Jugador> items) {
        super(context, R.layout.layout_fila_goleador, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_goleador, parent, false);
        TextView goleador = (TextView) row.findViewById(R.id.GOLjugadorTV);
        goleador.setText(getItem(position).getApellido()+" " + getItem(position).getNombre());
        TextView goles = (TextView) row.findViewById(R.id.GOLgoles);
        goles.setText(""+getItem(position).getGoles());
        escudo =(ImageView) row.findViewById(R.id.imageViewGoleadores);
        escudo.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipo()));
        isEnabled(position);

        goles.setTypeface(null, Typeface.BOLD);
        goleador.setTypeface(null, Typeface.BOLD);

        return(row);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
