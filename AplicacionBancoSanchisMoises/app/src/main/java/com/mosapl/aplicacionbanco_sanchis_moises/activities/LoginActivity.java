package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cliente;

public class LoginActivity extends AppCompatActivity {


    private EditText etUsuario;
    private EditText etPasword;
    private Button btnEntrar;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MiBancoOperacional api = MiBancoOperacional.getInstance(this);


        //Obtenemos una referencia a los controles de la interfaz.
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPasword = (EditText) findViewById(R.id.etPasword);
        btnEntrar = (Button) findViewById(R.id.btnAceptar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        //Implementamos el evento click del botón entrar.
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente clienteComprobar = new Cliente();
               // clienteComprobar.setNif(etUsuario.getText().toString());
               // clienteComprobar.setClaveSeguridad(etPasword.getText().toString());
                clienteComprobar.setNif("11111111A");
                clienteComprobar.setClaveSeguridad("12345");
               Cliente clienteExistente = api.login(clienteComprobar);
                if (clienteExistente != null){
                    //Creamos el Intent.
                    Intent intentEntrar = new Intent(LoginActivity.this, MainActivity.class);
                    // Creamos la informacion a pasar entre actividades.
                    intentEntrar.putExtra("Cliente", clienteExistente);
                    //Iniciamos la nueva actividad
                    startActivity(intentEntrar);
                }else{
                    Toast.makeText(LoginActivity.this, "El cliente no se encuentra en nuestra base de datos.", Toast.LENGTH_SHORT).show();
                }


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