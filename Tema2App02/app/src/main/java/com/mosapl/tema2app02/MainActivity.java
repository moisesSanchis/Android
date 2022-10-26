package com.mosapl.tema2app02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz.
        txtNombre = (EditText)findViewById(R.id.TxtNombre);
        btnAceptar = (Button) findViewById(R.id.BtnAceptar);

        //Implementamos el evento click del boton.
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent.
                Intent intent = new Intent(MainActivity.this, SaludoActivity.class);

                //Creamos la información para pasar entre actividades.
                intent.putExtra("NOMBRE", txtNombre.getText().toString());

                //Iniciamos la nueva actividad.
                startActivity(intent);
            }
        });
    }
}