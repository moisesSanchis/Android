package com.mosapl.actividad1tema4moisessanchis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolderDatos> implements View.OnClickListener{
    ArrayList<Comida> listaComidas;
    //Propiedad para el onclick.
    private View.OnClickListener listener;

    public DatosAdapter(ArrayList<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }
    // El layout manager invoca este método para renderizar cada elemento del RecyclerView.
    @NonNull
    @Override
    public DatosAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_comida, null, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosAdapter.ViewHolderDatos holder, int position) {
        //Obtenemos un elemento del dataset según su posicion y reemplazamos el contenido usando tales datos.
        holder.asignarDatos(listaComidas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaComidas.size();
    }
    // Para realizar onClick
    public void setOnClickListener(View.OnClickListener listener){
       this.listener = listener;
    }
    @Override
    public void onClick(View view) {
    if(listener!=null){
        listener.onClick(view);
    }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView ivIcono;
        TextView tvComida, tvPais;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            ivIcono = itemView.findViewById(R.id.ivIcono);
            tvComida = itemView.findViewById(R.id.tvComida);
            tvPais = itemView.findViewById(R.id.tvPais);
        }

        public void asignarDatos(Comida comida) {
            ivIcono.setImageResource(comida.getFoto());
            tvComida.setText(comida.getNombre());
            tvPais.setText(comida.getOrigen());
        }
    }
}
