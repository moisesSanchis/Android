package com.mosapl.t5a01sanchisplamoises.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosapl.t5a01sanchisplamoises.R;
import com.mosapl.t5a01sanchisplamoises.pojos.Cancion;

import java.util.ArrayList;

public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.ViewHolderDatos>{

    ArrayList<Cancion>listaCanciones;
    public CancionAdapter(ArrayList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
    @NonNull
    @Override
    public CancionAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cancion, null, false);
        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CancionAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaCanciones.get(position));
    }


    @Override
    public int getItemCount() {
        return listaCanciones.size();
    }
public class ViewHolderDatos extends RecyclerView.ViewHolder {

    TextView titulo, duracion;

    public ViewHolderDatos(@NonNull View itemView) {
        super(itemView);

        titulo = itemView.findViewById(R.id.txtCanTitulo);
        duracion = itemView.findViewById(R.id.txtCanDuracion);
    }

    public void asignarDatos(Cancion cancion) {

        titulo.setText(cancion.getTitulo());
        duracion.setText(String.valueOf(cancion.getDuracion()));

    }

}
}
