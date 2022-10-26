package com.engiri.tema5app6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNotificacion;
    public static final String FIRST_CHANNEL_ID = "first_channel_id";
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Programamos las notificaciones para versión >= API 26
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            // Creamos el canal de comunicación
            NotificationChannel channel =
                    new NotificationChannel(FIRST_CHANNEL_ID,
                                     "MISNOTIFICACIONES",
                                            NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager =
                    (NotificationManager) getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            // Creamos la notificación con la clase correspondiente
             builder = new NotificationCompat.Builder(this, FIRST_CHANNEL_ID)
                    .setSmallIcon(android.R.drawable.stat_sys_warning)
                    .setContentTitle("Mensaje de Alerta")
                    .setContentText("Ejemplo de notificación.")
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Si necesitamos un texto mucho más largo para la " +
                                     "notificación que ocupe más de una línea..."));
        }

        btnNotificacion = (Button)findViewById(R.id.btnNotificacion);

        btnNotificacion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent notIntent =
                        new Intent(MainActivity.this, MainActivity.class);

                PendingIntent contIntent = PendingIntent.getActivity(
                        MainActivity.this, 0, notIntent, 0);

                builder.setContentIntent(contIntent);

                // Patrón de vibración: 1 segundo vibra, 0.5 segundos para, 1 segundo vibra
                // long[] pattern = new long[]{1000,500,1000};
                // builder.setVibrate(pattern);

                Vibrator vibrador=((Vibrator) getSystemService(VIBRATOR_SERVICE));
                vibrador.vibrate(1000);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(1, builder.build());

            }
        });
    }
}