package com.engiri.tema11app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnMapGeneral;
    private Button btnMapUbicacion;
    private Button btnMapMarkers;
    private Button btnMapPolilineas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMapGeneral = (Button) findViewById(R.id.btnMapGeneral);
        btnMapUbicacion = (Button) findViewById(R.id.btnMapUbicacion);
        btnMapMarkers = (Button) findViewById(R.id.btnMapMarkers);
        btnMapPolilineas = (Button) findViewById(R.id.btnMapPolilineas);

        btnMapGeneral.setOnClickListener(this);
        btnMapUbicacion.setOnClickListener(this);
        btnMapMarkers.setOnClickListener(this);
        btnMapPolilineas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(MainActivity.this, MapsActivity.class);

        switch (view.getId()) {
            case R.id.btnMapGeneral:
                i.putExtra("operacion", 0);
                startActivity(i);
                break;
            case R.id.btnMapUbicacion:
                i.putExtra("operacion", 1);
                startActivity(i);
                break;
            case R.id.btnMapMarkers:
                i.putExtra("operacion", 2);
                startActivity(i);
                break;
            case R.id.btnMapPolilineas:
                i.putExtra("operacion", 3);
                startActivity(i);
                break;
        }
    }
}