package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
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
        equipo.setText(getItem(position).getEquipo());
        posicion.setText(getItem(position).getPosicion().toString());
        TextView pj = (TextView) row.findViewById(R.id.POSpj);
        pj.setText(getItem(position).getPj());
        TextView pg = (TextView) row.findViewById(R.id.POSpg);
        pg.setText(getItem(position).getPg());
        TextView pp = (TextView) row.findViewById(R.id.POSpp);
        pp.setText(getItem(position).getPp().toString());
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
        //escudo.setImageResource(R.drawable.escudo_colon);


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



        //pts.setTextAppearance(R.color.colorNegro);
        //if(getItem(0).getPosicion().equals("#")){
        //    int negro= R.color.colorNegro;
         //   posicion.setHighlightColor(negro);

        /////////////////

            //Funcionens para resaltar, pero tira excepcion

            //Spannable spanText = Spannable.Factory.getInstance().newSpannable(posicion.getText());
            //spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 14, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            //posicion.setText(spanText);

            //Spannable spanText2 = Spannable.Factory.getInstance().newSpannable(equipo.getText());
            //spanText2.setSpan(new BackgroundColorSpan(0xFFFFFF00), 14, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            //posicion.setText(spanText2);
        //}

        return(row);
    }




}
