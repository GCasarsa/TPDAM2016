package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Administrador on 03/02/2017.
 */

public class AdapterTarjetaA extends ArrayAdapter<Jugador> {
    LayoutInflater inflater;

    public AdapterTarjetaA(Context context, List<Jugador> items) {
        super(context, R.layout.layout_fila_tarjeta, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_tarjeta, parent, false);
        TextView jugador = (TextView) row.findViewById(R.id.TAR_A_jugador);
        jugador.setText(getItem(position).getApellido());
        TextView numTarjetas = (TextView) row.findViewById(R.id.TAR_A_num);
        numTarjetas.setText(""+getItem(position).getAmarillas());
        ImageView imagenAmarilla = (ImageView) row.findViewById(R.id.imageViewTarjetaAmarilla);
        imagenAmarilla.setImageResource(R.drawable.tarjetaamarilla);
        final ImageView escudo =(ImageView) row.findViewById(R.id.TAR_A_imageViewJugador);


        if(getItem(position).getEquipo().equals("aldosivi")) escudo.setImageResource(R.drawable.escudo_aldosivi);
        else if(getItem(position).getEquipo().equals("arsenal")) escudo.setImageResource(R.drawable.escudo_arsenal);
        else if(getItem(position).getEquipo().equals("bandfield")) escudo.setImageResource(R.drawable.escudo_banfield);
        else if(getItem(position).getEquipo().equals("belgrano")) escudo.setImageResource(R.drawable.escudo_belgrano);
        else if(getItem(position).getEquipo().equals("boca")) escudo.setImageResource(R.drawable.escudo_boca);
        else if(getItem(position).getEquipo().equals("central")) escudo.setImageResource(R.drawable.escudo_central);
        else if(getItem(position).getEquipo().equals("colon")) escudo.setImageResource(R.drawable.escudo_colon);
        else if(getItem(position).getEquipo().equals("defensa y justicia")) escudo.setImageResource(R.drawable.escudo_defensa);
        else if(getItem(position).getEquipo().equals("estudiantes")) escudo.setImageResource(R.drawable.escudo_estudiantes);
        else if(getItem(position).getEquipo().equals("gimnasia")) escudo.setImageResource(R.drawable.escudo_gimnasia);
        else if(getItem(position).getEquipo().equals("godoy Cruz")) escudo.setImageResource(R.drawable.escudo_godoy);
        else if(getItem(position).getEquipo().equals("huracan")) escudo.setImageResource(R.drawable.escudo_huracan);
        else if(getItem(position).getEquipo().equals("independiente")) escudo.setImageResource(R.drawable.escudo_independiente);
        else if(getItem(position).getEquipo().equals("lanus")) escudo.setImageResource(R.drawable.escudo_lanus);
        else if(getItem(position).getEquipo().equals("racing")) escudo.setImageResource(R.drawable.escudo_racing);
        else if(getItem(position).getEquipo().equals("river")) escudo.setImageResource(R.drawable.escudo_river);
        else if(getItem(position).getEquipo().equals("san lorenzo")) escudo.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(getItem(position).getEquipo().equals("union")) escudo.setImageResource(R.drawable.escudo_union);
        else if(getItem(position).getEquipo().equals("velez")) escudo.setImageResource(R.drawable.escudo_velez);


        return(row);
    }




}
