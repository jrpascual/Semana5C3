package com.jrpascual.semana3c3.presentador;

import android.content.Context;
import android.util.Log;

import com.jrpascual.semana3c3.activity.IFavoritasView;
import com.jrpascual.semana3c3.db.ConstructorFavoritos;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 22/04/2017.
 */

public class FavoritasPresentador implements IFavoritasPresentador{

    private Context context;
    private IFavoritasView iFavoritasView;
    private ConstructorFavoritos constructorFavoritos;
    private ArrayList<Mascota> mascotas;

    public FavoritasPresentador(IFavoritasView iFavoritasView, Context context) {
        this.iFavoritasView = iFavoritasView;
        this.context = context;
        obetenerFavoritasBaseDatos();
    }

    @Override
    public void obetenerFavoritasBaseDatos( ) {
        constructorFavoritos = new ConstructorFavoritos(context);
        mascotas = constructorFavoritos.obetenerDatos();
        mostrarFavoritasRV();

    }

    @Override
    public void mostrarFavoritasRV() {
        iFavoritasView.inicializarAdaptadorRV(iFavoritasView.crearAdaptador(mascotas));
        iFavoritasView.generarLinearLayoutVertical();

    }
}
