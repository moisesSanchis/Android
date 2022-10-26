package com.engiri.tema4app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.lista);

        // Creamos los datos, iniciarlizar el adaptador y lo relacionamos
        String[] data = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lista.setAdapter(adaptador);
    }
}