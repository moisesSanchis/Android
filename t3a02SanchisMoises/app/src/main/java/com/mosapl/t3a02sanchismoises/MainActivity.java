package com.mosapl.t3a02sanchismoises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton botonMapa, botonInformacion, botonAlarma, botonFoto, botonPapelera, botonCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonMapa = (ImageButton) findViewById(R.id.btnMapa);
        botonMapa.setOnClickListener(this);
        botonAlarma = (ImageButton) findViewById(R.id.btnAlarma);
        botonAlarma.setOnClickListener(this);
        botonCompartir = (ImageButton) findViewById(R.id.btnCompartir);
        botonCompartir.setOnClickListener(this);
        botonFoto = (ImageButton) findViewById(R.id.btnFoto);
        botonFoto.setOnClickListener(this);
        botonInformacion = (ImageButton) findViewById(R.id.btnInformacion);
        botonInformacion.setOnClickListener(this);
        botonPapelera = (ImageButton) findViewById(R.id.btnPapelera);
        botonPapelera.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, BlankActivity.class);
        switch (v.getId()) {
            case R.id.btnMapa:
                 intent.putExtra("Mensaje", "Mapa");
                startActivity(intent);
                break;
            case R.id.btnAlarma:
                intent.putExtra("Mensaje", "Alarma");
                startActivity(intent);
                break;
            case R.id.btnCompartir:
               intent.putExtra("Mensaje", "Compartir");
                startActivity(intent);
                break;
            case R.id.btnFoto:
               intent.putExtra("Mensaje", "Foto");
                startActivity(intent);
                break;
            case R.id.btnInformacion:
                intent.putExtra("Mensaje", "Informacion");
                startActivity(intent);
                break;
            case R.id.btnPapelera:
               intent.putExtra("Mensaje", "Papelera");
                startActivity(intent);
                break;
        }
    }
}