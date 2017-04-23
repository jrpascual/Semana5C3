package com.jrpascual.semana3c3.adapters;

import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 31/03/2017.
 * Clase adaptador de Mascotas
 * Contiene una clase inner MascotaViewHolder
 *  Primero creo MascotaViewHolder que hereda de RecyclerView.ViewHolder
 *  Luego hago que MascotaFotoAdaptador here de de RecyclerView.Adapter
 *  Luego añadimos el constructor de MascotaFotoAdaptador
 */

public class MascotaFotoAdaptador extends RecyclerView.Adapter<MascotaFotoAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;

    public MascotaFotoAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    // Inflar el layout y pasarlo al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar el LayoutCardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotafotocardview,parent,false);
        return new MascotaViewHolder(v) ;
    }
    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.txContador.setText(String.valueOf(mascota.getContador()));

    }

    @Override
    public int getItemCount() { // Cantidad de elementos que tiene la lista
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView txContador;
        private ImageView imgHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imFotoMascotaFotos);
            txContador = (TextView) itemView.findViewById(R.id.tvFotoContador);
        }
    }


}
