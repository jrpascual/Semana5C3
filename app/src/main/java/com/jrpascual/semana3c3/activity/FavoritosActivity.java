package com.jrpascual.semana3c3.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.adapters.MascotaAdaptador;
import com.jrpascual.semana3c3.modelo.Mascota;
import com.jrpascual.semana3c3.presentador.FavoritasPresentador;
import com.jrpascual.semana3c3.presentador.IFavoritasPresentador;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IFavoritasView{

    private ArrayList<Mascota> mascotasFavs;
    private RecyclerView listaMascotas;
    private IFavoritasPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFav);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        Bundle paremtros = getIntent().getExtras();
        mascotasFavs = (ArrayList<Mascota>) paremtros.get("favoritas");
        */
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);
        presentador = new FavoritasPresentador(this,getApplicationContext());
/*  Quitado al implementar la interfaz
        inicializarListaMascotas();
        inicializarAdaptador();
 */
    }

    /* Quitado al implementar la interfaz
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavs);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotasFavs = new ArrayList<Mascota>();
        mascotasFavs.add(new Mascota("Jacky",R.drawable.jacky,9));
        mascotasFavs.add(new Mascota("Sira",R.drawable.sira,7));
        mascotasFavs.add(new Mascota("Coco",R.drawable.coco,6));
        mascotasFavs.add(new Mascota("Doro",R.drawable.doro,5));
        mascotasFavs.add(new Mascota("Toni",R.drawable.toni,3));
    }
    */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this, getApplicationContext());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
