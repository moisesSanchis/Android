package com.mosapl.t5a01sanchisplamoises.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mosapl.t5a01sanchisplamoises.R;
import com.mosapl.t5a01sanchisplamoises.adapters.CancionAdapter;
import com.mosapl.t5a01sanchisplamoises.pojos.Cancion;
import com.mosapl.t5a01sanchisplamoises.pojos.DiscoDatos;

import java.util.ArrayList;

public class CancionFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CancionAdapter mAdapter;
    private ArrayList<Cancion> datos;

    public CancionFragment() {
        this.datos = null;
        // Required empty public constructor
    }
    public CancionFragment(ArrayList<Cancion> datos) {
        this.datos = datos;
    }
    public static CancionFragment newInstance(ArrayList<Cancion> datos) {
        CancionFragment fragment = new CancionFragment(datos);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cancion_fragment, container, false);

        if (datos == null){
            datos = DiscoDatos.DISCOS.get(0).getCanciones();
        }

        mRecyclerView = view.findViewById(R.id.rvCancion);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new CancionAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
