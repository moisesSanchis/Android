package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mosapl.aplicacionbanco_sanchis_moises.R;

public class WelcomeActivity extends AppCompatActivity {
    private Button botonIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Obtenemos referencia a el control del boton de la interfaz.
        botonIniciar = (Button) findViewById(R.id.btnIniciar);
        //Implementamos el evento click del boton.
        botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent.
                Intent intentIniciar = new Intent(WelcomeActivity.this, LoginActivity.class);
                //Iniciamos la nueva actividad.
                startActivity(intentIniciar);
            }
        });
    }
}