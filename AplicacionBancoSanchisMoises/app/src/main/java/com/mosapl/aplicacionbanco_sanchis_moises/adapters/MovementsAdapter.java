package com.mosapl.aplicacionbanco_sanchis_moises.adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosapl.aplicacionbanco_sanchis_moises.R;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Cuenta;
import com.mosapl.aplicacionbanco_sanchis_moises.api.pojo.Movimiento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MovementsAdapter extends RecyclerView.Adapter<MovementsAdapter.ViewHolderDatos> {
    private Spinner spCuentas;
   ArrayList<Movimiento> listaMovimientos;

   public MovementsAdapter(ArrayList<Movimiento>listaMovimientos){
       this.listaMovimientos = listaMovimientos;
   }

    @NonNull
    @Override
    public MovementsAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_movimientos, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MovementsAdapter.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        //Obtenemos un elemento del dataset según su posicion y reemplazamos el contenido usando tales datos.
        holder.asignarDatos(listaMovimientos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaMovimientos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tvMovimientos, tvDatos;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvMovimientos= itemView.findViewById(R.id.tvMovimientosOperacion);
            tvDatos = itemView.findViewById(R.id.tvMovimientosDatosOperacion);
        }

        public void asignarDatos(Movimiento movimiento) {
            String importe = String.valueOf(movimiento.getImporte());
            String fecha = new SimpleDateFormat("dd,mm,yyyy").format(movimiento.getFechaOperacion());
            String operacion = String.valueOf(movimiento.getDescripcion());

            tvMovimientos.setText(operacion);
            tvDatos.setText(fecha+":  "+importe);

        }
    }

}
