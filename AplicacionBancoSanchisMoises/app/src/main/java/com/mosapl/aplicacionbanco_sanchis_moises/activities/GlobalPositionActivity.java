package com.mosapl.aplicacionbanco_sanchis_moises.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.adapters.AccountsAdapter;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBD;
import com.mosapl.aplicacionbanco_sanchis_moises.api.bd.MiBancoOperacional;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cuenta;

import java.util.ArrayList;

public class GlobalPositionActivity extends AppCompatActivity {
    private CardView cvCuentas;
    private AccountsAdapter mAdapter;
    private ArrayList<Cuenta> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_position);
    }
}