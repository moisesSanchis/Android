package com.engiri.tema8app1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.engiri.tema8app1.R;
import com.engiri.tema8app1.api.HipotecasDAO;

public class HipotecasAdapter extends
        RecyclerView.Adapter<HipotecasAdapter.ViewHolderDatos> implements View.OnClickListener{

    private HipotecasDAO hipotecasDAO = null;
    private Cursor cursor = null;

    // Propiedad para el onClick
    private View.OnClickListener listener;

    public HipotecasAdapter(Context context, Cursor cursor) {
        this.hipotecasDAO = new HipotecasDAO(context);
        this.hipotecasDAO.abrir();
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list,
                null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        // Para realizar onClick
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        cursor.moveToPosition(position);
        @SuppressLint("Range") String nombre =
                cursor.getString(cursor.getColumnIndex("nombre"));
        holder.asignarDatos(nombre);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
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

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tv_nombre;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.txtNombre);
        }

        public void asignarDatos(String nombre) {
            tv_nombre.setText(nombre);

            @SuppressLint("Range") String pasivo =
                    cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_PASIVO));

            if (pasivo.equals("S")){
                tv_nombre.setTextColor(Color.GRAY);
            } else {
                tv_nombre.setTextColor(Color.BLACK);
            }

        }

    }
}