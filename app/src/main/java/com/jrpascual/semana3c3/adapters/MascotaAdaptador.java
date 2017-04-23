package com.jrpascual.semana3c3.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.db.BaseDatos;
import com.jrpascual.semana3c3.db.ConstructorFavoritos;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 31/03/2017.
 * Clase adaptador de Mascotas
 * Contiene una clase inner MascotaViewHolder
 *  Primero creo MascotaViewHolder que hereda de RecyclerView.ViewHolder
 *  Luego hago que MascotaAdaptador here de de RecyclerView.Adapter
 *  Luego añadimos el constructor de MascotaAdaptador
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    Activity activity;
    Context context;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity, Context context){
        this.mascotas = mascotas;
        this.context = context;
        this.activity = activity;
    }

    // Inflar el layout y pasarlo al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar el LayoutCardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotacardview,parent,false);
        return new MascotaViewHolder(v) ;
    }
    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.txContador.setText(String.valueOf(mascota.getContador()));
        holder.txNombre.setText(mascota.getNombre());
        holder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setContador(1);
                holder.txContador.setText(String.valueOf(mascota.getContador()));
                BaseDatos bd = new BaseDatos(context);
                // Comprobamos que no hubiesemos dado ya al like para que no se repita
                if(!bd.existeMascota(mascota)){
                    ConstructorFavoritos.insertarMascota(bd,mascota);
                }

            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que tiene la lista
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView txNombre;
        private TextView txContador;
        private ImageView imgHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            txNombre = (TextView) itemView.findViewById(R.id.tvNombrePet);
            txContador = (TextView) itemView.findViewById(R.id.tvContador);
            imgHueso = (ImageView) itemView.findViewById(R.id.Hueso);
        }
    }


}
