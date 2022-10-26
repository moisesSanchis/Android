package com.engiri.tema7app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPreferencias;
    private Button btnMostrarPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = (Button) findViewById(R.id.btnPreferencias);
        btnMostrarPreferencias = (Button) findViewById(R.id.btnMostrarPreferencias);
        btnPreferencias.setOnClickListener(this);
        btnMostrarPreferencias.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPreferencias:
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.btnMostrarPreferencias:
                SharedPreferences pref =
                        PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("Tema7App2", "Reproducir música: "
                        + pref.getBoolean("reproducirMusica", false));
                Log.i("Tema7App2", "Nick: " + pref.getString("nick", ""));
                Log.i("Tema7App2", "Pais: " + pref.getString("pais", ""));
                break;
        }
    }
}