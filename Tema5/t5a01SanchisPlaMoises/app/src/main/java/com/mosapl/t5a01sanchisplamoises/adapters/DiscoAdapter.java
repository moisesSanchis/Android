package com.mosapl.t5a01sanchisplamoises.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosapl.t5a01sanchisplamoises.R;
import com.mosapl.t5a01sanchisplamoises.pojos.Disco;

import java.util.ArrayList;

public class DiscoAdapter extends RecyclerView.Adapter<DiscoAdapter.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<Disco>listaDiscos;
   private View.OnClickListener listener;

    public DiscoAdapter(ArrayList<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }


    @NonNull
    @Override
    public DiscoAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_disco, null, false);
        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaDiscos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDiscos.size();
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo, descripcion;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
        }

        public void asignarDatos(Disco disco) {
            titulo.setText(disco.getTitulo());
            String des = disco.getGrupo() + " - " + disco.getYear();
            descripcion.setText(des);

        }
    }
}
