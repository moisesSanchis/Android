package com.engiri.tema5app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toast por defecto
        Button btnDefecto= (Button) findViewById(R.id.btnDefecto);

        btnDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                          "Se ha pulsado el botón",
                               Toast.LENGTH_SHORT).show();
            }
        });

        // Toast con Gravity
        Button btnGravity= (Button) findViewById(R.id.btnGravity);

        btnGravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast2 = Toast.makeText(getApplicationContext(),
                                         "Toast con gravity",
                                              Toast.LENGTH_SHORT);

                toast2.setGravity(Gravity.LEFT,0,0);
                toast2.show();
            }
        });

        // Toast Personalizado
        Button btnPersonalizado= (Button) findViewById(R.id.btnPersonalizado);

        btnPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast3 = new Toast(getApplicationContext());

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout,
                        (ViewGroup) findViewById(R.id.lytLayout));

                TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
                txtMsg.setText("Toast Personalizado");

                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setView(layout);
                toast3.show();
            }
        });
    }

}
