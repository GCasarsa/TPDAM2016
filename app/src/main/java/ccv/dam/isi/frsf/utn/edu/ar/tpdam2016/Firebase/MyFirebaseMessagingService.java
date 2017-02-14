package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.SubMenu;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

/**
 * Created by Gabriel on 15/01/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    ArrayList<String> preferencias;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ArrayList<String> busqueda;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Context ctx = getApplicationContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        preferencias = new ArrayList<>();

        Log.d(TAG, "¡Mensaje recibido::::::::!" + remoteMessage.getNotification().getBody());

        for(int i = 1; i <=8; i++){
            if(pref.getBoolean(""+i,false)) preferencias.add(""+i);
        }
        //sendNotification(remoteMessage.getNotification(),pref);
        buscarEquipos(remoteMessage, pref);

    }

       public void buscarEquipos(final RemoteMessage mensaje, final SharedPreferences p){
            busqueda=new ArrayList<>();
            posicionBD = database.getReference("datos/equipos/primeradivision");
            posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                for(int i = 0; i < preferencias.size(); i++){
                    if(newPost.get("id").toString().equals(preferencias.get(i))) {
                        Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(), newPost.get("division").toString());
                        busqueda.add(equipo.getNombre());
                    }
                }

                String cuerpoMensaje = mensaje.getNotification().getBody().toUpperCase();
                for (int i=0;i<busqueda.size();i++){
                    if(cuerpoMensaje.contains(busqueda.get(i).toUpperCase())){
                        sendNotification(mensaje.getNotification(),p);
                        break;
                    }
                }

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

    private void sendNotification(RemoteMessage.Notification  notificacion, SharedPreferences prefRingtone) {
        Intent intent= new Intent(this, VerEquiposActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String alarms = prefRingtone.getString("ringtone", null);
        Uri uri = Uri.parse(alarms);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, intent, FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(notificacion.getTitle()).setContentText(notificacion.getBody()).setAutoCancel(true).setSound(uri).setContentIntent(pendingIntent);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
