package com.engiri.tema5app4.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.engiri.tema5app4.R;

public class BlueFragment extends Fragment {

    public BlueFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(BlueFragment.class.getSimpleName(), "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        Log.v(BlueFragment.class.getSimpleName(), "onActivityCreated");
        super.onActivityCreated(state);
    }

    @Override
    public void onAttach (Activity activity) {
        Log.v(BlueFragment.class.getSimpleName(), "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onViewStateRestored (Bundle savedInstanceState) {
        Log.v(BlueFragment.class.getSimpleName(), "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.v(BlueFragment.class.getSimpleName(), "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(BlueFragment.class.getSimpleName(), "onResume");
    }

    @Override
    public void onPause() {
        Log.v(BlueFragment.class.getSimpleName(), "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.v(BlueFragment.class.getSimpleName(), "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.v(BlueFragment.class.getSimpleName(), "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.v(BlueFragment.class.getSimpleName(), "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.v(BlueFragment.class.getSimpleName(), "onDetach");
        super.onDetach();
    }
}