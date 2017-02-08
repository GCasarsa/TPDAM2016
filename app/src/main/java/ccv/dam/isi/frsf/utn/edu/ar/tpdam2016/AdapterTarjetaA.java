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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Administrador on 03/02/2017.
 */

public class AdapterTarjetaA extends ArrayAdapter<Jugador> {
    LayoutInflater inflater;
    ImageView escudo;

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
        escudo =(ImageView) row.findViewById(R.id.TAR_A_imageViewJugador);
        escudo.setImageResource(CargarEscudos.cargarEscudo(getItem(position).getEquipo()));


        //if(getItem(position).getEquipo().equals("ARGENTINO DE SAN CARLOS")) new DownloadImageTask().execute("https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fargentinodesancarlos.png?alt=media&token=71c06334-6990-4961-8d24-106ac38bacfc");
        /*if(getItem(position).getEquipo().equals("ARGENTINO DE SAN CARLOS")) escudo.setImageResource(R.drawable.argentinodesancarlos);
        else if(getItem(position).getEquipo().equals("EL CADI")) escudo.setImageResource(R.drawable.escudo_elcadi);
        else if(getItem(position).getEquipo().equals("ATENEO INMACULADA")) escudo.setImageResource(R.drawable.escudo_ateneo);
        else if(getItem(position).getEquipo().equals("BANCO PROVINCIAL")) escudo.setImageResource(R.drawable.escudo_bancoprovincial);
        else if(getItem(position).getEquipo().equals("CICLON RACING")) escudo.setImageResource(R.drawable.escudo_ciclonracing);
        else if(getItem(position).getEquipo().equals("COLON")) escudo.setImageResource(R.drawable.escudo_colon);
        else if(getItem(position).getEquipo().equals("COLON DE SAN JUSTO")) escudo.setImageResource(R.drawable.escudo_colonsanjusto);
        else if(getItem(position).getEquipo().equals("COSMOS FC")) escudo.setImageResource(R.drawable.escudo_clubcosmos);
        else if(getItem(position).getEquipo().equals("QUILLA")) escudo.setImageResource(R.drawable.escudo_quilla);
        else if(getItem(position).getEquipo().equals("GIMNASIA DE CIUDADELA")) escudo.setImageResource(R.drawable.escudo_gimnasiaciudadela);
        else if(getItem(position).getEquipo().equals("LA PERLA DEL OESTE")) escudo.setImageResource(R.drawable.escudo_laperladeloeste);
        else if(getItem(position).getEquipo().equals("NEWELLS DE SANTA FE")) escudo.setImageResource(R.drawable.escudo_newells);
        else if(getItem(position).getEquipo().equals("SAN JUSTINO")) escudo.setImageResource(R.drawable.escudo_sanjustino);
        else if(getItem(position).getEquipo().equals("UNION")) escudo.setImageResource(R.drawable.escudo_union);
        else if(getItem(position).getEquipo().equals("UNL")) escudo.setImageResource(R.drawable.escudo_unl);
        else if(getItem(position).getEquipo().equals("LA SALLE")) escudo.setImageResource(R.drawable.escudo_lasalle);
        else if(getItem(position).getEquipo().equals("BELGRANO DE CORONDA")) escudo.setImageResource(R.drawable.escudo_belgranodecoronda);
        else if(getItem(position).getEquipo().equals("PUCARA")) escudo.setImageResource(R.drawable.escudo_pucara);
        else if(getItem(position).getEquipo().equals("INDEPENDIENTE DE SANTO TOME")) escudo.setImageResource(R.drawable.escudo_independiente);*/


        return(row);
    }

    class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
        protected void onPreExecute() {}
        protected Drawable doInBackground(String... urls) {
            return downloadImage(urls[0]);
        }
        protected void onPostExecute(Drawable imagen) {
            escudo.setImageDrawable(imagen);
            //progressDialog.dismiss();
        }
        private Drawable downloadImage(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                InputStream is = (InputStream)url.getContent();
                return Drawable.createFromStream(is, "src");
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }




}
