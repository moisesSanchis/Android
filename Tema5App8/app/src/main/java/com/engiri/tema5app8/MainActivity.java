package com.engiri.tema5app8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnackbar = (Button) findViewById(R.id.btnSnackBar);

        btnSnackbar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Ejemplo 1
                // Snackbar.make(view, "Texto a mostrar", Snackbar.LENGTH_LONG).show();

                // Ejemplo 2
                /* Snackbar.make(view, "Texto a mostrar", Snackbar.LENGTH_LONG)
                        .setAction("Pulse para ejecutar", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //código a ejecutar
                            }
                        }).show();
                */

                // Ejemplo 3
                Snackbar.make(view, "Texto a mostrar", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.CYAN)
                        .setAction("Pulse para ejecutar", new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                //Código a ejecutar
                            }
                        }).show();
            }


        });


    }
}