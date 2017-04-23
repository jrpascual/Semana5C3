package com.jrpascual.semana3c3.activity;

import com.jrpascual.semana3c3.adapters.MascotaAdaptador;
import com.jrpascual.semana3c3.adapters.MascotaFotoAdaptador;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 22/04/2017.
 */

public interface IFavoritasView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
