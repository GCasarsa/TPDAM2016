package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import java.net.URL;
import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class Adapter extends ArrayAdapter<Equipo> {
    LayoutInflater inflater;
    FirebaseAuth autenticacion;
    Context contexto;
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
        final ImageView imageView =(ImageView) row.findViewById(R.id.ivVerEquiposEscudo);
        nombreDelEquipo.setText(getItem(position).getNombre().toString());
        division.setText(getItem(position).getDivision());
        if(getItem(position).getNombre().toString().equals("ALDOSIVI")) imageView.setImageResource(R.drawable.escudo_aldosivi);
        else if(getItem(position).getNombre().toString().equals("ARSENAL DE SARANDÍ")) imageView.setImageResource(R.drawable.escudo_arsenal);
        else if(getItem(position).getNombre().toString().equals("BANFIELD")) imageView.setImageResource(R.drawable.escudo_banfield);
        else if(getItem(position).getNombre().toString().equals("BELGRANO")) imageView.setImageResource(R.drawable.escudo_belgrano);
        else if(getItem(position).getNombre().toString().equals("BOCA JUNIORS")) imageView.setImageResource(R.drawable.escudo_boca);
        else if(getItem(position).getNombre().toString().equals("ROSARIO CENTRAL")) imageView.setImageResource(R.drawable.escudo_central);
        else if(getItem(position).getNombre().toString().equals("COLON DE SANTA FE")) imageView.setImageResource(R.drawable.escudo_colon);
        else if(getItem(position).getNombre().toString().equals("DEFENSA Y JUSTICIA")) imageView.setImageResource(R.drawable.escudo_defensa);
        else if(getItem(position).getNombre().toString().equals("ESTUDIANTES")) imageView.setImageResource(R.drawable.escudo_estudiantes);
        else if(getItem(position).getNombre().toString().equals("GIMNASIA DE LA PLATA")) imageView.setImageResource(R.drawable.escudo_gimnasia);
        else if(getItem(position).getNombre().toString().equals("GODOY CRUZ")) imageView.setImageResource(R.drawable.escudo_godoy);
        else if(getItem(position).getNombre().toString().equals("HURACAN")) imageView.setImageResource(R.drawable.escudo_huracan);
        else if(getItem(position).getNombre().toString().equals("INDEPENDIENTE")) imageView.setImageResource(R.drawable.escudo_independiente);
        else if(getItem(position).getNombre().toString().equals("LANUS")) imageView.setImageResource(R.drawable.escudo_lanus);
        else if(getItem(position).getNombre().toString().equals("NEWELLS OLD BOYS")) imageView.setImageResource(R.drawable.escudo_newells);
        else if(getItem(position).getNombre().toString().equals("RACING CLUB")) imageView.setImageResource(R.drawable.escudo_racing);
        else if(getItem(position).getNombre().toString().equals("RIVER PLATE")) imageView.setImageResource(R.drawable.escudo_river);
        else if(getItem(position).getNombre().toString().equals("SAN LORENZO")) imageView.setImageResource(R.drawable.escudo_sanlorenzo);
        else if(getItem(position).getNombre().toString().equals("UNION DE SANTA FE")) imageView.setImageResource(R.drawable.escudo_union);
        else if(getItem(position).getNombre().toString().equals("VELEZ")) imageView.setImageResource(R.drawable.escudo_velez);

        return(row);
    }

}