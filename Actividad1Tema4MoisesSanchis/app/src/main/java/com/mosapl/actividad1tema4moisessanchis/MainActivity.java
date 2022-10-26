package com.mosapl.actividad1tema4moisessanchis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DatosAdapter mAdapter;
    private ArrayList<Comida> datos = ComidaDatos.COMIDAS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler);
        // Nuestro RecyclerView usara un linear layout manager --> VERTICAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Nuestro RecyclerView usara un linear layout manager --> HORIZONTAL
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Nuestro RecyclerView usara un Grid layout manager --> TABULAR
        // GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);
        // Asociamos un adapter
        mAdapter = new DatosAdapter(datos);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = datos.get(mRecyclerView.getChildAdapterPosition(view)).getUrl() ;
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}