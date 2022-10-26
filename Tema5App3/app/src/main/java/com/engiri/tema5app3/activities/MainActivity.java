package com.engiri.tema5app3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.engiri.tema5app3.R;
import com.engiri.tema5app3.fragments.CorreosListener;
import com.engiri.tema5app3.fragments.DetailFragment;
import com.engiri.tema5app3.fragments.ListFragment;
import com.engiri.tema5app3.pojos.Correo;

public class MainActivity extends AppCompatActivity implements CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment frgListado =
                (ListFragment)getSupportFragmentManager()
                        .findFragmentById(R.id.frgListado);

        frgListado.setCorreosListener(this);
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle) != null);

        if(hayDetalle) {
            ((DetailFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.frgDetalle)).mostrarDetalle(c.getTexto());
        }
        else {
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("TextoDetalle", c.getTexto());
            startActivity(i);
        }

    }
}