package com.engiri.tema5app3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.engiri.tema5app3.R;
import com.engiri.tema5app3.pojos.Correo;

import java.util.ArrayList;

public class CorreoAdapter extends RecyclerView.Adapter<CorreoAdapter.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<Correo> listaCorreos;

    // Propiedad para el onClick
    private View.OnClickListener listener;

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public CorreoAdapter(ArrayList<Correo> listaCorreos) {
        this.listaCorreos = listaCorreos;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element, null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        // Para realizar onClick
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos
        holder.asignarDatos(listaCorreos.get(position));
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return listaCorreos.size();
    }

    // Para realizar onClick
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    // Para realizar onClick
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        // en este ejemplo cada elemento consta solo de un título y subtítulo
        TextView de, asunto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            de = itemView.findViewById(R.id.tvDe);
            asunto = itemView.findViewById(R.id.tvAsunto);
        }

        public void asignarDatos(Correo correo) {
            de.setText(correo.getDe());
            asunto.setText(correo.getAsunto());
        }
    }
}
