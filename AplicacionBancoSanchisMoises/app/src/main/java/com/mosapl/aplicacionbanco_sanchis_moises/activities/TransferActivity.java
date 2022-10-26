package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mosapl.aplicacionbanco_sanchis_moises.R;

public class TransferActivity extends AppCompatActivity {
    private Spinner spCuentas, spCuentaPropia, spMoneda;
    private RadioButton rbCuentaPropia, rbCuentaAjena;
    private EditText etCuentaAjena, etCantidad;
    private Button btnEnviar, btnCancelar;
    private CheckBox cbJustificante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        final String[] datos = new String[]{"ES90-2080-5801-10-1234567891", "ES90-2080-5801-10-1234567589", "ES90-2080-5801-10-1234567123", "ES90-2080-5801-10-1234567456"};
        final String[] monedas = new String[]{"€", "$", "¥", "£"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        ArrayAdapter<String> adaptadorMoneda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monedas);

        spCuentas = (Spinner) findViewById(R.id.spCuentas);
        spMoneda = (Spinner) findViewById(R.id.spMoneda);
        spCuentaPropia = (Spinner) findViewById(R.id.spCuentas2);
        etCuentaAjena = (EditText) findViewById(R.id.ptCuentaAjena);
        etCuentaAjena.setVisibility(View.INVISIBLE);
        rbCuentaAjena = (RadioButton) findViewById(R.id.rbAjena);
        rbCuentaPropia = (RadioButton) findViewById(R.id.rbPropia);
        etCantidad = (EditText) findViewById(R.id.etCantidad);
        btnEnviar = (Button) findViewById(R.id.btnEnviarTranferencia);
        btnCancelar = (Button) findViewById(R.id.btnCancelarTransferencia);
        cbJustificante = (CheckBox) findViewById(R.id.cbJustificante);


        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCuentas.setAdapter(adaptador);
        spCuentaPropia.setAdapter(adaptador);
        adaptadorMoneda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMoneda.setAdapter(adaptadorMoneda);

        rbCuentaPropia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCuentaAjena.setVisibility(View.INVISIBLE);
                spCuentaPropia.setVisibility(View.VISIBLE);
            }
        });

        rbCuentaAjena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCuentaAjena.setVisibility(View.VISIBLE);
                spCuentaPropia.setVisibility(View.INVISIBLE);

            }
        });


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbJustificante.isChecked()) {
                    if (rbCuentaPropia.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.TxtCuentaOrigen) + ": \n" + spCuentas.getSelectedItem().toString() + "\n" + getString(R.string.TxtCuentaPropia) + ": " + spCuentaPropia.getSelectedItem().toString() + "\n" + getString(R.string.TxtImporte) + etCantidad.getText().toString() + spMoneda.getSelectedItem().toString() + "\n" + cbJustificante.getText().toString(), Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.TxtCuentaOrigen) + ": \n" + spCuentas.getSelectedItem().toString() + "\n" + getString(R.string.TxtCuentaAjena) + ": " + etCuentaAjena.getText().toString() + "\n" + getString(R.string.TxtImporte) + etCantidad.getText().toString() + spMoneda.getSelectedItem().toString() + "\n" + cbJustificante.getText().toString(), Toast.LENGTH_LONG);
                        toast.show();
                    }


                } else {
                    if (rbCuentaPropia.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.TxtCuentaOrigen) + ": \n" + spCuentas.getSelectedItem().toString() + "\n" + getString(R.string.TxtCuentaPropia) + ": " + spCuentaPropia.getSelectedItem().toString() + "\n" + getString(R.string.TxtImporte) + etCantidad.getText().toString() + spMoneda.getSelectedItem().toString(), Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.TxtCuentaOrigen) + ": \n" + spCuentas.getSelectedItem().toString() + "\n" + getString(R.string.TxtCuentaAjena) + ": " + etCuentaAjena.getText().toString() + "\n" + getString(R.string.TxtImporte) + etCantidad.getText().toString() + spMoneda.getSelectedItem().toString() , Toast.LENGTH_LONG);
                        toast.show();
                    }

                }


            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(TransferActivity.this, MainActivity.class);
            startActivity(intent);
            }
        });

    }
}