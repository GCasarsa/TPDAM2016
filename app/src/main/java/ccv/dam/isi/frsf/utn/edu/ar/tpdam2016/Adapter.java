package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class Adapter extends ArrayAdapter<Equipo> {
    LayoutInflater inflater;
    FirebaseAuth autenticacion;
    Context contexto;
    ImageView imageView;
    private static final String TAG = "Storage#MainActivity";

    public Adapter(Context context, List<Equipo> items) {
        super(context, R.layout.layout_fila_equipo, items);
        inflater= LayoutInflater.from(context);
        autenticacion = FirebaseAuth.getInstance();
        contexto = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_equipo, parent, false);
        TextView nombreDelEquipo = (TextView) row.findViewById(R.id.tvVerEquiposNombre);
        TextView division = (TextView) row.findViewById(R.id.tvVerEquiposLiga);
        imageView =(ImageView) row.findViewById(R.id.ivVerEquiposEscudo);
        nombreDelEquipo.setText(getItem(position).getNombre().toString());

        division.setText(getItem(position).getDivision());
        //new DownloadImageTask().execute(getItem(position).getEscudo());
        return(row);
    }
    class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
        protected void onPreExecute() {}
        protected Drawable doInBackground(String... urls) {
            return downloadImage(urls[0]);
        }
        protected void onPostExecute(Drawable imagen) {
            imageView.setImageDrawable(imagen);
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