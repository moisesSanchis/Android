package com.mosapl.tema2app02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {
    private TextView txtSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        //Localizamos los controles.
        txtSaludo = (TextView)findViewById(R.id.TxtSaludo);

        //Recuperamos la informacion pasada en el intent.
        String mensajeRecibido = this.getIntent().getStringExtra("NOMBRE");

        //Construimos el mensaje a mostrar.
        txtSaludo.setText("Hola " + mensajeRecibido);
    }
}