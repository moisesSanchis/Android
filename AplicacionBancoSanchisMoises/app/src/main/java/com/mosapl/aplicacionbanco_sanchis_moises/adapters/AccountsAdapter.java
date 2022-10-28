package com.mosapl.aplicacionbanco_sanchis_moises.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cuenta;

import java.util.ArrayList;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.ViewHolderDatos>{
   ArrayList <Cuenta>listaCuentas;

    public AccountsAdapter(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    // El layout manager invoca este método para renderizar cada elemento del RecyclerView.
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_cuentas, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        //Obtenemos un elemento del dataset según su posicion y reemplazamos el contenido usando tales datos.
        holder.asignarDatos(listaCuentas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaCuentas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

            TextView tvNumCuenta, tvSaldo;


            public ViewHolderDatos(@NonNull View itemView) {
                super(itemView);
                tvNumCuenta = itemView.findViewById(R.id.tvMovimientosOperacion);
                tvSaldo = itemView.findViewById(R.id.tvMovimientosDatosOperacion);
            }

            public void asignarDatos(Cuenta cuenta) {
                tvNumCuenta.setText(cuenta.getNumeroCuenta());
                tvSaldo.setText(String.valueOf(cuenta.getSaldoActual()));
                if (cuenta.getSaldoActual()<0){
                    tvSaldo.setTextColor(Color.RED);
                }else{
                    tvSaldo.setTextColor(Color.GREEN);
                }
            }
        }



}
