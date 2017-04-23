package com.jrpascual.semana3c3.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jrpascual.semana3c3.activity.FavoritosActivity;
import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.adapters.MascotaAdaptador;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 13/04/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView estrella = (ImageView) getActivity().findViewById(R.id.imvEstrella);
        estrella.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  //  Toast.makeText(getBaseContext(), "No tienes favoritos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),FavoritosActivity.class);
                //intent.putExtra("favoritas",mascotas);
                startActivity(intent);
            }
        });

        return  v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this.getActivity(), getContext());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Jacky",R.drawable.jacky,0));
        mascotas.add(new Mascota("Bruno",R.drawable.bruno,0));
        mascotas.add(new Mascota("Clara",R.drawable.clara,0));
        mascotas.add(new Mascota("Lana",R.drawable.lana,0));
        mascotas.add(new Mascota("Buffo",R.drawable.buffo,0));
        mascotas.add(new Mascota("Baby",R.drawable.jackb,0));
        mascotas.add(new Mascota("Pipin",R.drawable.pipi,0));
        mascotas.add(new Mascota("Sira",R.drawable.sira,0));
        mascotas.add(new Mascota("Coco",R.drawable.coco,0));
        mascotas.add(new Mascota("Doro",R.drawable.doro,0));
        mascotas.add(new Mascota("Toni",R.drawable.toni,0));
    }


}
