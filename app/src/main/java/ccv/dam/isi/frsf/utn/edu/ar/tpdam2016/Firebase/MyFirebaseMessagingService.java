package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 15/01/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendNotification(remoteMessage.getNotification().getBody());
    }
    private void sendNotification(String messageBody) {
        Intent intent= new Intent(this, Inicio.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Fútbol de Santa Fe").setContentText(messageBody).setAutoCancel(true).setSound(defaultSoundUri).setContentIntent(pendingIntent);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}