package com.engiri.tema5app3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.engiri.tema5app3.R;
import com.engiri.tema5app3.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detalle =
                (DetailFragment)getSupportFragmentManager()
                        .findFragmentById(R.id.frgDetalle);

        detalle.mostrarDetalle(getIntent().getStringExtra("TextoDetalle"));

    }

}