package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.adapters.AccountsAdapter;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cliente;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cuenta;

import java.util.ArrayList;

public class GlobalPositionActivity extends AppCompatActivity {
    private RecyclerView rvCuentas;
    private AccountsAdapter mAdapter;
    private ArrayList<Cuenta> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_position);
        MiBancoOperacional api = MiBancoOperacional.getInstance(this);
        Cliente clienteActual = (Cliente) this.getIntent().getSerializableExtra("Cliente");
        datos = api.getCuentas(clienteActual);
        rvCuentas = (RecyclerView) findViewById(R.id.rvTarjetaPosicion);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCuentas.setLayoutManager(layoutManager);
        mAdapter = new AccountsAdapter(datos);
        rvCuentas.setAdapter(mAdapter);
    }
}