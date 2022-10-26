package com.mosapl.tema4app02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DatosAdapter mAdapter;
    private ArrayList<Tarea> datos = TareaDatos.TAREAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerId);
        // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Nuestro RecyclerView usará un linear layout manager --> HORIZONTAL
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Nuestro RecyclerView usará un Grid layout manager --> TABULAR
        // GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);
        // Asociamos un adapter
        mAdapter = new DatosAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);

    }
}