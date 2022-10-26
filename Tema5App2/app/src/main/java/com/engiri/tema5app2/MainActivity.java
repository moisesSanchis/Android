package com.engiri.tema5app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.engiri.tema5app2.fragments.BlueFragment;
import com.engiri.tema5app2.fragments.GreenFragment;
import com.engiri.tema5app2.fragments.RedFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAzul, btnVerde, btnRojo;

    BlueFragment fragmentAzul;
    GreenFragment fragmentVerde;
    RedFragment fragmentRojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAzul = (Button) findViewById(R.id.btnAzul);
        btnVerde = (Button) findViewById(R.id.btnVerde);
        btnRojo = (Button) findViewById(R.id.btnRojo);

        btnAzul.setOnClickListener(this);
        btnVerde.setOnClickListener(this);
        btnRojo.setOnClickListener(this);

        // Creamos los objetos a los 3 fragments
        fragmentAzul = new BlueFragment();
        fragmentVerde = new GreenFragment();
        fragmentRojo = new RedFragment();

        // Insertamos en el FrameLayout (contenedorFragments) el fragment Rojo
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedorFragments, fragmentRojo).commit();
    }

    @Override
    public void onClick(View view) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnAzul:
                // Reemplazamos en el FrameLayout (contenedorFragments) el fragment Azul
                transaction.replace(R.id.contenedorFragments, fragmentAzul);
                break;
            case R.id.btnVerde:
                // Reemplazamos en el FrameLayout (contenedorFragments) el fragment Verde
                transaction.replace(R.id.contenedorFragments, fragmentVerde);
                break;
            case R.id.btnRojo:
                // Reemplazamos en el FrameLayout (contenedorFragments) el fragment Rojo
                transaction.replace(R.id.contenedorFragments, fragmentRojo);
                break;
        }

        transaction.commit();
    }
}