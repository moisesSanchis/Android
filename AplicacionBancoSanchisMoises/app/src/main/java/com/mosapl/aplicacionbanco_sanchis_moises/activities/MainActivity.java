package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cliente;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtSaludo;
    private Button btnPosicionGlobal, btnMovimientos, btnTransferencias, btnCambioContrasena, btnPromociones, btnCajeros, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiBancoOperacional api = MiBancoOperacional.getInstance(this);

        //Obtenemos la referencia a el control de la interfaz.
        txtSaludo = (TextView) findViewById(R.id.tvSaludo);
        btnPosicionGlobal = (Button) findViewById(R.id.btnPosicionGlobal);
        btnPosicionGlobal.setOnClickListener(this);
        btnMovimientos = (Button) findViewById(R.id.btnMovimientos);
        btnMovimientos.setOnClickListener(this);
        btnTransferencias = (Button)findViewById(R.id.btnTransferencias);
        btnTransferencias.setOnClickListener(this);
        btnCambioContrasena = (Button) findViewById(R.id.btnCambioContrasena);
        btnCambioContrasena.setOnClickListener(this);
        btnPromociones = (Button)findViewById(R.id.btnPromociones);
        btnPromociones.setOnClickListener(this);
        btnCajeros = (Button)findViewById(R.id.btnCajeros);
        btnCajeros.setOnClickListener(this);
        btnSalir = (Button)findViewById(R.id.btnSalirMain);
        btnSalir.setOnClickListener(this);
        Cliente clienteActual = (Cliente) this.getIntent().getSerializableExtra("Cliente");
        //Construimos el mensaje a mostrar.
        txtSaludo.setText( txtSaludo.getText()+ " " + clienteActual.getNombre());
    }

    @Override
    public void onClick(View v) {
        Cliente clienteActual = (Cliente) this.getIntent().getSerializableExtra("Cliente");
        switch (v.getId()){
            case R.id.btnPosicionGlobal:
                Intent intentPosicionGlobal = new Intent(MainActivity.this, GlobalPositionActivity.class);
                intentPosicionGlobal.putExtra("Cliente", clienteActual);
                startActivity(intentPosicionGlobal);
                break;
            case R.id.btnMovimientos:
                Intent intentMovimientos = new Intent(MainActivity.this, MovementsActivity.class);
                intentMovimientos.putExtra("Cliente", clienteActual);
                startActivity(intentMovimientos);
                break;
            case R.id.btnTransferencias:
                Intent intentTransferencias = new Intent(MainActivity.this, TransferActivity.class);
                startActivity(intentTransferencias);
                intentTransferencias.putExtra("Cliente", clienteActual);
                break;
            case R.id.btnCambioContrasena:
                //Creamos el Intent.
                Intent intentCambiarContrasena = new Intent(MainActivity.this, ChangePassActivity.class);
                intentCambiarContrasena.putExtra("Cliente", clienteActual);
                //Iniciamos la nueva actividad
                startActivity(intentCambiarContrasena);
                break;
            case R.id.btnPromociones:

                break;
            case R.id.btnCajeros:
                break;
            case R.id.btnSalirMain:
                //Creamos el Intent.
                Intent intentSalirMain = new Intent(MainActivity.this, WelcomeActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intentSalirMain);
                break;



        }
    }
}