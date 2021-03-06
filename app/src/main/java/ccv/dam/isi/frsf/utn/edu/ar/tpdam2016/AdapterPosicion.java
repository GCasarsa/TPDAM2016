package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.FilaPosicion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Administrador on 01/02/2017.
 */
public class AdapterPosicion extends ArrayAdapter<FilaPosicion> {
    LayoutInflater inflater;

    public AdapterPosicion(Context context, List<FilaPosicion> items) {
        super(context, R.layout.layout_fila_posicion, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_posicion, parent, false);
        TextView posicion = (TextView) row.findViewById(R.id.POSnumeroOrden);
        TextView equipo = (TextView) row.findViewById(R.id.POSnombreEquipo);
        equipo.setText(getItem(position).getEquipo().toUpperCase());
        posicion.setText(getItem(position).getPosicion().toString());
        TextView pj = (TextView) row.findViewById(R.id.POSpj);
        pj.setText(getItem(position).getPj());
        TextView pg = (TextView) row.findViewById(R.id.POSpg);
        pg.setText(getItem(position).getPg());
        TextView pp = (TextView) row.findViewById(R.id.POSpp);
        pp.setText(getItem(position).getPp());
        TextView pe = (TextView) row.findViewById(R.id.POSpe);
        pe.setText(getItem(position).getPe());
        TextView gf = (TextView) row.findViewById(R.id.POSgf);
        gf.setText(getItem(position).getGf());
        TextView gc = (TextView) row.findViewById(R.id.POSgc);
        gc.setText(getItem(position).getGc());
        TextView dif = (TextView) row.findViewById(R.id.POSdif);
        dif.setText(getItem(position).getDif());
        TextView pts = (TextView) row.findViewById(R.id.POSpts);
        pts.setText(getItem(position).getPts());
        final ImageView escudo =(ImageView) row.findViewById(R.id.POSimageView);
        escudo.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipo().toUpperCase()));

        isEnabled(position);

        equipo.setTypeface(null, Typeface.BOLD);
        posicion.setTypeface(null, Typeface.BOLD);
        pts.setTypeface(null, Typeface.BOLD);

        return(row);
    }
    @Override
    public boolean isEnabled(int position) {
        return false;
    }




}
