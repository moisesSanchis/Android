package com.engiri.tema2app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    private TextView txtSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        //Localizar los controles
        txtSaludo = (TextView)findViewById(R.id.TxtSaludo);

        //Recuperamos la información pasada en el intent
        String mensajeRecibido = this.getIntent().getStringExtra("NOMBRE");

        //Construimos el mensaje a mostrar
        txtSaludo.setText("Hola " + mensajeRecibido);
    }

}