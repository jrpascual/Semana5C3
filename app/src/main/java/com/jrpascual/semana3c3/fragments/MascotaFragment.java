package com.jrpascual.semana3c3.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jrpascual.semana3c3.adapters.MascotaAdaptador;
import com.jrpascual.semana3c3.adapters.MascotaFotoAdaptador;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

import com.jrpascual.semana3c3.R;

public class MascotaFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    /*
    // Esto comentado forma parte de lo que era el Activity, ahora es un Fragment
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_fragment);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        */
        View v = inflater.inflate(R.layout.mascota_fragment, container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvFotosMiMascota);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }


    public void inicializarAdaptador(){
        MascotaFotoAdaptador adaptador = new MascotaFotoAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Jacky1",R.drawable.jacky,9));
        mascotas.add(new Mascota("Jacky2",R.drawable.jackb,5));
        mascotas.add(new Mascota("Jacky3",R.drawable.jackycara,5));
        mascotas.add(new Mascota("Jacky4",R.drawable.jackypeque,5));
        mascotas.add(new Mascota("Buffo",R.drawable.nojacky,0));


    }
}
