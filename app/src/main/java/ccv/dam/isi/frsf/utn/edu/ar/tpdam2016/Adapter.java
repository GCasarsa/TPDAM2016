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

    public Adapter(Context context, List<Equipo> items) {
        super(context, R.layout.layout_fila_equipo, items);
        inflater= LayoutInflater.from(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.layout_fila_equipo, parent, false);
        TextView nombreDelEquipo = (TextView) row.findViewById(R.id.textViewNombreFila);
        nombreDelEquipo.setText(getItem(position).getNombre().toString());
        final ImageView verDetalle =(ImageView) row.findViewById(R.id.imageVerDetalle);
        verDetalle.setImageResource(R.drawable.editar);
        final ImageView borrar =(ImageView) row.findViewById(R.id.imageEliminar);
        borrar.setImageResource(R.drawable.borrar);

/*
        final ImageView imageView =(ImageView) row.findViewById(R.id.imageFotoEquipo);
        String escudo = "gs://tpdam2016.appspot.com" + getItem(position).getEscudo().toString();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        System.out.println(escudo);
        StorageReference storageRef = storage.getReferenceFromUrl(escudo);

        File localFile = null;
        try {
            localFile = File.createTempFile("images", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                StorageReference temp = taskSnapshot.getStorage();
                try {
                    imageView.setImageBitmap(BitmapFactory.decodeStream( new URL(temp.getPath()).openStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                exception.printStackTrace();
            }
        });
        /*StorageReference storageRef = storage.getReferenceFromUrl("gs://tpdam2016.appspot.com/img/escudos/");

        StorageReference imagen = storageRef.child(getItem(position).getEscudo().toString());

        final long ONE_MEGABYTE = 1024 * 1024;
        imagen.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bm);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });*/
        return(row);
    }


}