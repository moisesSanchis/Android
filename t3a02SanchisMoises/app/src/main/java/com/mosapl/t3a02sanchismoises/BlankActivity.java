package com.mosapl.t3a02sanchismoises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class BlankActivity extends AppCompatActivity {
    private TextView mensaje;
    private ImageButton volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        mensaje = (TextView) findViewById(R.id.tvMensaje);
        volver = (ImageButton)findViewById(R.id.btnVolver);
        String mensajeRecibido = this.getIntent().getStringExtra("Mensaje");
        mensaje.setText(mensajeRecibido);
        Toast.makeText(getApplicationContext(),"Se ha pulsado el boton: "+ mensajeRecibido, Toast.LENGTH_LONG).show();
   volver.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(BlankActivity.this, MainActivity.class);
           startActivity(intent);
       }
   });
    }
}