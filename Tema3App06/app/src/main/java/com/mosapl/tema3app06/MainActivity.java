package com.mosapl.tema3app06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2 = (Button) findViewById(R.id.btnFuncioAnonima);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Info de forma anonima", Toast.LENGTH_LONG).show();
            }
        });

        btn3 = (Button) findViewById(R.id.btnImplements);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btnImplements2);
        btn4.setOnClickListener(this);
    }
    public void info(View view){
        Toast.makeText(getApplicationContext(), "Info de XML", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

//        Toast.makeText(getApplicationContext(), "Info de Implements", Toast.LENGTH_LONG).show();
    switch (v.getId()){
        case R.id.btnImplements:
            Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_LONG).show();
            break;
        case R.id.btnImplements2:
            Toast.makeText(getApplicationContext(), "Info de Implements2", Toast.LENGTH_LONG).show();
            break;
    }


    }
}