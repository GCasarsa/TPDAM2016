package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class Adapter extends ArrayAdapter<Equipo> {
    LayoutInflater inflater;

    Adapter(Context context, List<Equipo> items) {
        super(context, R.layout.fila_equipo, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.fila_equipo, parent, false);
        TextView nombreDelEquipo = (TextView) row.findViewById(R.id.textViewNombreFila);
        nombreDelEquipo.setText(getItem(position).getNombre().toString());
        final ImageView imageView =(ImageView) row.findViewById(R.id.imageFotoEquipo);
        imageView.setImageResource(getResources().getIdentifier(getItem(position).getEscudo().toString()), "drawable", "package.name");

        /*FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://tpdam2016.appspot.com/escudos").child("talleres.png");

        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
                imageView.setImageURI(uri);
            }
        });
*/
        final ImageView verDetalle =(ImageView) row.findViewById(R.id.imageVerDetalle);
        verDetalle.setImageResource(R.drawable.editar);
        final ImageView borrar =(ImageView) row.findViewById(R.id.imageEliminar);
        borrar.setImageResource(R.drawable.borrar);
        return(row);
    }


}