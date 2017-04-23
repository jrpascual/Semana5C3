package com.jrpascual.semana3c3.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jrpascual.semana3c3.R;
import com.jrpascual.semana3c3.activity.Contacto_Activity;
import com.jrpascual.semana3c3.activity.activity_about;
import com.jrpascual.semana3c3.adapters.PageAdapter;
import com.jrpascual.semana3c3.fragments.MascotaFragment;
import com.jrpascual.semana3c3.fragments.RecyclerViewFragment;
import com.jrpascual.semana3c3.modelo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        setUpViewPager();

        /* Esto hay que pasarlo al fragment_recyclerview
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView estrella = (ImageView) findViewById(R.id.imvEstrella);
        estrella.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  //  Toast.makeText(getBaseContext(), "No tienes favoritos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,FavoritosActivity.class);
                //intent.putExtra("favoritas",mascotas);
                startActivity(intent);
            }
        });

        */
    }

    // Crear el arraylist de fragments que vamos a mostrar
    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new MascotaFragment());
        return fragments;
    }

    // Metodo para cargar los fragments en el viewpager
    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.mypet);
        tabLayout.getTabAt(0).setIcon(R.drawable.myhome);
    }

     /* Esto hay que pasarlo al fragment_recyclerview
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
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
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this,activity_about.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(this,Contacto_Activity.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
