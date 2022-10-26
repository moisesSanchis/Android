package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mosapl.aplicacionbanco_sanchis_moises.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etPasword;
    private Button btnEntrar;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Obtenemos una referencia a los controles de la interfaz.
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPasword = (EditText) findViewById(R.id.etPasword);
        btnEntrar = (Button) findViewById(R.id.btnAceptar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        //Implementamos el evento click del botón entrar.
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent.
                Intent intentEntrar = new Intent(LoginActivity.this, MainActivity.class);
                // Creamos la informacion a pasar entre actividades.
                intentEntrar.putExtra("Nombre", etUsuario.getText().toString());
                //Iniciamos la nueva actividad
                startActivity(intentEntrar);
            }
        });
        //Implementamos el evento para el botón salir.
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent.
                Intent intentSalir = new Intent(LoginActivity.this, WelcomeActivity.class);
                //Iniciamos la nueva actividad.
                startActivity(intentSalir);
            }
        });
    }
}