package com.engiri.tema3app5;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // boton = (Button) findViewById(R.id.btn_pulsar);
        // boton.setOnClickListener(this);

        Button boton = (Button)findViewById(R.id.btn_pulsar);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sePulsa(v);
            }
        });

    }
    /*
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btn_pulsar)
                sePulsa(view);
        }
    */
    private void sePulsa(View v) {
        Toast.makeText(this, "Pulsado.", Toast.LENGTH_SHORT).show();
    }
}