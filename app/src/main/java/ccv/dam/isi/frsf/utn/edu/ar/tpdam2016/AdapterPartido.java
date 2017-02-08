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
        agregarEscudoL(getItem(position).getEquipoLocal().toString());
        escudoV = (ImageView) row.findViewById(R.id.imageViewEscudoVisita);
        agregarEscudoV(getItem(position).getEquipoVisitante().toString());

        return(row);
    }
    public void agregarEscudoL(String local){
        if(local.equals("ALDOSIVI")) escudoL.setImageResource(R.drawable.escudo_aldosivi);
        else if(local.equals("ARSENAL DE SARANDÍ")) escudoL.setImageResource(R.drawable.escudo_arsenal);
        else if(local.equals("BANFIELD")) escudoL.setImageResource(R.drawable.escudo_banfield);
        else if(local.equals("BELGRANO")) escudoL.setImageResource(R.drawable.escudo_belgrano);
        else if(local.equals("BOCA JUNIORS")) escudoL.setImageResource(R.drawable.escudo_boca);
        else if(local.equals("ROSARIO CENTRAL")) escudoL.setImageResource(R.drawable.escudo_central);
        else if(local.equals("COLON DE SANTA FE")) escudoL.setImageResource(R.drawable.escudo_colon);
        else if(local.equals("DEFENSA Y JUSTICIA")) escudoL.setImageResource(R.drawable.escudo_defensa);
        else if(local.equals("ESTUDIANTES")) escudoL.setImageResource(R.drawable.escudo_estudiantes);
        else if(local.equals("GIMNASIA DE LA PLATA")) escudoL.setImageResource(R.drawable.escudo_gimnasia);
        else if(local.equals("GODOY CRUZ")) escudoL.setImageResource(R.drawable.escudo_godoy);
        else if(local.equals("HURACAN")) escudoL.setImageResource(R.drawable.escudo_huracan);
        else if(local.equals("INDEPENDIENTE")) escudoL.setImageResource(R.drawable.escudo_independiente);
        else if(local.equals("LANUS")) escudoL.setImageResource(R.drawable.escudo_lanus);
        else if(local.equals("NEWELLS OLD BOYS")) escudoL.setImageResource(R.drawable.escudo_newells);
        else if(local.equals("RACING CLUB")) escudoL.setImageResource(R.drawable.escudo_racing);
        else if(local.equals("RIVER PLATE")) escudoL.setImageResource(R.drawable.escudo_river);
        else if(local.equals("SAN LORENZO")) escudoL.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(local.equals("UNION DE SANTA FE")) escudoL.setImageResource(R.drawable.escudo_union);
        else if(local.equals("VELEZ")) escudoL.setImageResource(R.drawable.escudo_velez);
    }
    public void agregarEscudoV(String visitante){
        if(visitante.equals("ALDOSIVI")) escudoV.setImageResource(R.drawable.escudo_aldosivi);
        else if(visitante.equals("ARSENAL DE SARANDÍ")) escudoV.setImageResource(R.drawable.escudo_arsenal);
        else if(visitante.equals("BANFIELD")) escudoV.setImageResource(R.drawable.escudo_banfield);
        else if(visitante.equals("BELGRANO")) escudoV.setImageResource(R.drawable.escudo_belgrano);
        else if(visitante.equals("BOCA JUNIORS")) escudoV.setImageResource(R.drawable.escudo_boca);
        else if(visitante.equals("ROSARIO CENTRAL")) escudoV.setImageResource(R.drawable.escudo_central);
        else if(visitante.equals("COLON DE SANTA FE")) escudoV.setImageResource(R.drawable.escudo_colon);
        else if(visitante.equals("DEFENSA Y JUSTICIA")) escudoV.setImageResource(R.drawable.escudo_defensa);
        else if(visitante.equals("ESTUDIANTES")) escudoV.setImageResource(R.drawable.escudo_estudiantes);
        else if(visitante.equals("GIMNASIA DE LA PLATA")) escudoV.setImageResource(R.drawable.escudo_gimnasia);
        else if(visitante.equals("GODOY CRUZ")) escudoV.setImageResource(R.drawable.escudo_godoy);
        else if(visitante.equals("HURACAN")) escudoV.setImageResource(R.drawable.escudo_huracan);
        else if(visitante.equals("INDEPENDIENTE")) escudoV.setImageResource(R.drawable.escudo_independiente);
        else if(visitante.equals("LANUS")) escudoV.setImageResource(R.drawable.escudo_lanus);
        else if(visitante.equals("NEWELLS OLD BOYS")) escudoV.setImageResource(R.drawable.escudo_newells);
        else if(visitante.equals("RACING CLUB")) escudoV.setImageResource(R.drawable.escudo_racing);
        else if(visitante.equals("RIVER PLATE")) escudoV.setImageResource(R.drawable.escudo_river);
        else if(visitante.equals("SAN LORENZO")) escudoV.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(visitante.equals("UNION DE SANTA FE")) escudoV.setImageResource(R.drawable.escudo_union);
        else if(visitante.equals("VELEZ")) escudoV.setImageResource(R.drawable.escudo_velez);
    }
}
