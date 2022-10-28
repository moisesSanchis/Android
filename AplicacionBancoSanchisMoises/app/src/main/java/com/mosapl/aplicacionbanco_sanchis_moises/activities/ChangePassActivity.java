package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBD;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cliente;

public class ChangePassActivity extends AppCompatActivity {
    EditText etContrasenaActual, etNuevaContrasena, etRepiteNuevaContrasena;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
       MiBancoOperacional api = MiBancoOperacional.getInstance(this);
        Cliente clienteActual = (Cliente) this.getIntent().getSerializableExtra("Cliente");
        etContrasenaActual = (EditText) findViewById(R.id.etContrasenaActual);
        etNuevaContrasena = (EditText) findViewById(R.id.etNuevaContrasena);
        etRepiteNuevaContrasena = (EditText) findViewById(R.id.etRepiteNuevaContrasena);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contrasenaCliente = String.valueOf(clienteActual.getClaveSeguridad());
                String contrasenaActual = String.valueOf(etContrasenaActual.getText());
                String contrasenaActualValidar =String.valueOf(etNuevaContrasena.getText());
                String contrasenaRepetidaValidar = String.valueOf(etRepiteNuevaContrasena.getText());
                if((contrasenaCliente.equals(contrasenaActual))  && (contrasenaActualValidar.equals(contrasenaRepetidaValidar)) ){
                    clienteActual.setClaveSeguridad(contrasenaActualValidar);
                    api.changePassword(clienteActual);
                    Toast.makeText(ChangePassActivity.this, "Contraseña cambiada.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChangePassActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ChangePassActivity.this, "La contraseña no se encuentra en nuestra base de datos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}