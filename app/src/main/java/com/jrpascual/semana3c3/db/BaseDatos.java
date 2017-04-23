package com.jrpascual.semana3c3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Eversor on 23/04/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NAME     + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_IMG      + " INTEGER" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(sqLiteDatabase);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        sqLiteDatabase.close();
    }

    public boolean existeMascota(Mascota mascota){
        boolean existe = false;
         // Comprobar si ya se inserto la mascota para no insertarla de nuevo
        SQLiteDatabase  sqlexiste = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTAS + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_NAME +
                "='" + mascota.getNombre() + "'";
        Cursor cursor = sqlexiste.rawQuery(query,null);
        if(cursor.moveToNext()) existe = true;
        sqlexiste.close();
        return  existe;
    }

    public ArrayList<Mascota> obtenerFavoritas(){
        ArrayList<Mascota> favoritas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota fav = new Mascota();

            fav.setId(registros.getInt(0));
            fav.setNombre(registros.getString(1));
            fav.setFoto(registros.getInt(2));
            favoritas.add(fav);
        }
        db.close();
        return  favoritas;
    }

    public void borrarBBDD(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(sqLiteDatabase);

    }
}
