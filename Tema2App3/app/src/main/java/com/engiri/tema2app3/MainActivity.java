package com.engiri.tema2app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StringBuilder mensajes = new StringBuilder();
    TextView visor;

    private void escribir(String text){
        Log.d("CicloVida", text);
        mensajes.append(text);
        mensajes.append("\n");
        visor.setText(mensajes.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        visor = new TextView(this);
        visor.setText(mensajes.toString());
        setContentView(visor);
        escribir("Se ha llamado a onCreate()");

    }

    @Override
    public void onStart(){
        super.onStart();
        escribir("Se ha llamado a onStart");
    }


    @Override
    public void onResume(){
        super.onResume();
        escribir("Se ha llamado a onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        escribir("Se ha llamado a onPause");
        if (isFinishing()){
            escribir("Esta actividad está siendo destruida... ");
        }

    }

    @Override
    public void onStop(){
        super.onStop();
        escribir("Se ha llamado a onStop");
        if (isFinishing()){
            escribir("Esta actividad está siendo destruida... ");
        }

    }

    public void onRestart(){
        super.onRestart();
        escribir("Se ha llamado a onRestart");


    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        escribir("Se ha llamado a onDestroy");


    }
}
