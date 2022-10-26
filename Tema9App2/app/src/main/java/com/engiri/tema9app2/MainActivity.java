package com.engiri.tema9app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNumero;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnCalcular:
                calcularOperacion(view);
                break;
        }
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(edtNumero.getText().toString());
        txtResultado.append(n +"! = ");
        MiThread thread = new MiThread(n);
        thread.start();

    }

    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++){
            res=res * i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    private class MiThread extends Thread {

        private int n, res;

        public MiThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            //txtResultado.append(res + "\n");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txtResultado.append(res + "\n");
                }
            });
        }

    }
}