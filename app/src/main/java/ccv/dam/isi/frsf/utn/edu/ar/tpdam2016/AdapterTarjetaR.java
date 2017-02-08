package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Administrador on 03/02/2017.
 */

public class AdapterTarjetaR extends ArrayAdapter<Jugador> {
    LayoutInflater inflater;
    ImageView escudo;

    public AdapterTarjetaR(Context context, List<Jugador> items) {
        super(context, R.layout.layout_fila_tarjeta, items);
        inflater= LayoutInflater.from(context);
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.layout_fila_tarjeta, parent, false);
        TextView jugador = (TextView) row.findViewById(R.id.TAR_A_jugador);
        jugador.setText(getItem(position).getApellido()+" " + getItem(position).getNombre());
        TextView numTarjetas = (TextView) row.findViewById(R.id.TAR_A_num);
        numTarjetas.setText(""+getItem(position).getRojas());
        ImageView imagenAmarilla = (ImageView) row.findViewById(R.id.imageViewTarjetaAmarilla);
        imagenAmarilla.setImageResource(R.drawable.tarjetaroja);
        escudo=(ImageView) row.findViewById(R.id.TAR_A_imageViewJugador);
        escudo.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipo()));
        return(row);
    }
}