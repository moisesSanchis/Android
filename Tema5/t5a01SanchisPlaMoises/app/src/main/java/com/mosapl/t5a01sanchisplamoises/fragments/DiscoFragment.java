package com.mosapl.t5a01sanchisplamoises.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mosapl.t5a01sanchisplamoises.R;
import com.mosapl.t5a01sanchisplamoises.adapters.DiscoAdapter;
import com.mosapl.t5a01sanchisplamoises.adapters.DiscoListener;
import com.mosapl.t5a01sanchisplamoises.pojos.Disco;
import com.mosapl.t5a01sanchisplamoises.pojos.DiscoDatos;

import java.util.ArrayList;


public class DiscoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DiscoAdapter mAdapter;
    private ArrayList<Disco> datos = DiscoDatos.DISCOS;
    private DiscoListener listener;

    public DiscoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_disco, container, false);


        mRecyclerView = view.findViewById(R.id.rvDisco);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);


        mAdapter = new DiscoAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);


        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),
                        "Selección: " +
                                datos.get(mRecyclerView.getChildAdapterPosition(view)).getTitulo(),
                        Toast.LENGTH_LONG).show();


                int posicion = mRecyclerView.getChildAdapterPosition(view);
                //datos.get(posicion);

                if (listener != null) {
                    listener.onDiscoSeleccionado((Disco) datos.get(posicion));
                }

            }
        });

        return view;
    }
    public void setDiscoListener(DiscoListener listener) {
        this.listener = listener;
    }
}
