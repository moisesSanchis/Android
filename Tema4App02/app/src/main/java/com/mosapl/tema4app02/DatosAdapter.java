package com.mosapl.tema4app02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolderDatos> {
   ArrayList<Tarea> listaTareas;

    public DatosAdapter(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @NonNull
    @Override
    public DatosAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_tarea, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosAdapter.ViewHolderDatos holder, int position) {
    // - obtenemos un elemento del dataset según su posición
    // - reemplazamos el contenido usando tales datos
        holder.asignarDatos(listaTareas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView titulo, subtitulo;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.lblTitulo);
            subtitulo = itemView.findViewById(R.id.lblSubtitulo);
        }

        public void asignarDatos(Tarea tarea) {
            titulo.setText(tarea.getNombre());
            subtitulo.setText(tarea.getHora());
        }
    }
}
