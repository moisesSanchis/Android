package com.engiri.tema8app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.engiri.tema8app1.adapter.HipotecasAdapter;
import com.engiri.tema8app1.api.HipotecasDAO;
import com.engiri.tema8app1.utils.Constantes;

public class MainActivity extends AppCompatActivity {

    private HipotecasDAO hipotecaDAO;
    private Cursor cursor;
    private RecyclerView mRecyclerView;
    private HipotecasAdapter mAdapter;
    private TextView txtSinDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos la clase que nos permitira acceder a las operaciones de la db
        hipotecaDAO = new HipotecasDAO(this);

        try {
            // Abrimos la base de datos
            hipotecaDAO.abrir();

            // Obtenemos el cursor
            cursor = hipotecaDAO.getCursor();
            // Se indica a la Actividad principal que controle los recursos del cursor
            // Es decir, si se termina la Actividad, se elimina este cursor de memoria
            startManagingCursor(cursor);

            // Método para iniciar el RecyclerView
            iniciarRecyclerView();

            // Si hay datos no se muestra la etiqueta de Sin Datos
            if(cursor.getCount()>0){
                txtSinDatos = (TextView) findViewById(R.id.txtSinDatos);
                txtSinDatos.setVisibility(View.INVISIBLE);
                txtSinDatos.invalidate();
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(),
                    "Se ha producido un error al abrir la base de datos.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void iniciarRecyclerView() {
        mRecyclerView = findViewById(R.id.lista);

        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // Para poner un separador entre los diferente ítems de la lista
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(),
                        layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        // Asociamos un adapter (ver más adelante cómo definirlo)
        mAdapter = new HipotecasAdapter(this, cursor);

        // Para realizar onClick
        mAdapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int position =  mRecyclerView.getChildAdapterPosition(view) + 1;
                Toast.makeText(getApplicationContext(),"Selección: " + position,
                        Toast.LENGTH_SHORT).show();

                // Creamos el intent para abrir el formulario de hipotecas
                Intent i = new Intent(MainActivity.this, GestionHipotecasActivity.class);
                // Le pasamos que el modo en que lo vamos a abrir es solo de visualización
                i.putExtra(Constantes.C_MODO, Constantes.C_VISUALIZAR);
                // Le pasamos el valor del identificador de la hipoteca
                i.putExtra(HipotecasDAO.C_COLUMNA_ID, position);
                // Iniciamos la actividad esperando un resultado,
                // que en este caso no nos importa cual sea
                startActivityForResult(i, Constantes.C_VISUALIZAR);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent i;

        switch (item.getItemId()) {
            case R.id.menu_crear:
                i = new Intent(MainActivity.this, GestionHipotecasActivity.class);
                i.putExtra(Constantes.C_MODO, Constantes.C_CREAR);
                startActivityForResult(i, Constantes.C_CREAR);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Nos aseguramos que es la petición que hemos realizado
        switch(requestCode) {
            case Constantes.C_CREAR:
                if (resultCode == RESULT_OK)
                    recargar_lista();
            case Constantes.C_VISUALIZAR:
                if (resultCode == RESULT_OK)
                    recargar_lista();
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void recargar_lista() {
        HipotecasDAO hipotecasDAO = new HipotecasDAO(getBaseContext());
        hipotecasDAO.abrir();
        HipotecasAdapter hipotecasCursorAdapter =
                new HipotecasAdapter(this, hipotecasDAO.getCursor());

        // Método para iniciar el RecyclerView
        iniciarRecyclerView();
    }
}