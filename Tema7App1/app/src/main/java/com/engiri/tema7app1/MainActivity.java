package com.engiri.tema7app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo;
    private Button btnGuardar;
    private Button btnRecuperar;
    private TextView tvValorGuardado;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaramos los elementos con los que vamos a trabajar
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);
        tvValorGuardado = (TextView) findViewById(R.id.tvValorGuardado);

        // Obtenemos la referencia a la colección de preferencias
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        // Declaramos el evento onClick en el botón de guardar el correo,
        // de forma que salvamos los datos
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", edtCorreo.getText().toString());
                editor.commit();
            }
        });

        // Declaramos el evento onClick en el botón de cargar el correo
        // de las preferencias
        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String correo = prefs.getString("email", "Sin valor");
                tvValorGuardado.setText(correo);
            }
        });

    }
}