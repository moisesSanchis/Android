package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.adapters.MovementsAdapter;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cliente;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cuenta;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Movimiento;

import java.util.ArrayList;

public class MovementsActivity extends AppCompatActivity {
   private Spinner spCuentas;
   private ArrayList<Movimiento>movimientos;
   private ArrayList<Cuenta>cuentas;
   private ArrayList<String>nombreCuenta;
   private RecyclerView rvMovimientos;
   private MovementsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movements);
        Cliente clienteActual = (Cliente) this.getIntent().getSerializableExtra("Cliente");
        MiBancoOperacional api = MiBancoOperacional.getInstance(this);
        spCuentas =(Spinner) findViewById(R.id.spMovimientos);
        cuentas = api.getCuentas(clienteActual);
        nombreCuenta = obtenerNumeroCuenta(cuentas);
        ArrayAdapter<String>adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombreCuenta);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCuentas.setAdapter(adaptador);
        spCuentas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int posicion = position;
                rvMovimientos = (RecyclerView) findViewById(R.id.rvMovimientos);
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                movimientos =api.getMovimientos(cuentas.get(posicion));
                rvMovimientos.setLayoutManager(layoutManager);
                mAdapter = new MovementsAdapter(movimientos);
                rvMovimientos.setAdapter(mAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public ArrayList<String> obtenerNumeroCuenta(ArrayList<Cuenta>cuentasComprobar){
        ArrayList<String>numeroCuentas = new ArrayList<>();
        for (Cuenta cuentaActual:cuentasComprobar) {
          String datos =  cuentaActual.getBanco()+"-"+cuentaActual.getSucursal()+"-"+cuentaActual.getDc()+"-"+cuentaActual.getNumeroCuenta();
          numeroCuentas.add(datos);
        }
        return numeroCuentas;
    }
}