package com.jrpascual.semana3c3.db;

import android.content.ContentValues;
import android.content.Context;

import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 22/04/2017.
 */

public class ConstructorFavoritos {

    private Context context;
    private ArrayList<Mascota> mascotasFavs;

    public ConstructorFavoritos(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obetenerDatos(){
    /*
        // De momento se introducen dummy
        mascotasFavs = new ArrayList<Mascota>();
        mascotasFavs.add(new Mascota("Jacky", R.drawable.jacky,9));
        mascotasFavs.add(new Mascota("Sira",R.drawable.sira,7));
        mascotasFavs.add(new Mascota("Coco",R.drawable.coco,6));
        mascotasFavs.add(new Mascota("Doro",R.drawable.doro,5));
        mascotasFavs.add(new Mascota("Toni",R.drawable.toni,3));

      /*  BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
        */
        BaseDatos db = new BaseDatos(context);
      return db.obtenerFavoritas();
    }

    public static void insertarMascota(BaseDatos bd, Mascota mascota){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG, mascota.getFoto());
        bd.insertarMascota(contentValues);

    }

}
