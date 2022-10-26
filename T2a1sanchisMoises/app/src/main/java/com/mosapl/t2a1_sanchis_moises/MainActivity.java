package com.mosapl.t2a1_sanchis_moises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv3 = (TextView) findViewById(R.id.tv3);
        button = (Button)findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();
                int numero1 = Integer.parseInt(valor1);
                int numero2 = Integer.parseInt(valor2);
                int suma = numero1 + numero2;
                String resultado = String.valueOf(suma);
                tv3.setText(resultado);
            }
        });

    }

}