package com.lgcs.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this,CincoMascotas.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bird 1", R.drawable.bird_48,"5"));
        mascotas.add(new Mascota("Bird 2", R.drawable.bird_50,"6"));
        mascotas.add(new Mascota("Bird 3", R.drawable.bull_52,"7"));
        mascotas.add(new Mascota("Cat 1", R.drawable.cat_48,"16"));
        mascotas.add(new Mascota("Cat 2", R.drawable.cat_filled_50,"5"));
        mascotas.add(new Mascota("Chicken 1", R.drawable.chicken_52,"5"));
        mascotas.add(new Mascota("Bull 1", R.drawable.bull_52,"6"));
        mascotas.add(new Mascota("Cow 1", R.drawable.cow_filled_50,"8"));
        mascotas.add(new Mascota("Dog 1", R.drawable.dog_filled_50,"1"));
        mascotas.add(new Mascota("Duck 1", R.drawable.duck_52,"2"));
        mascotas.add(new Mascota("Horse 1", R.drawable.horse_filled_50,"3"));
        mascotas.add(new Mascota("Pig 1", R.drawable.pig_52,"2"));
        mascotas.add(new Mascota("Rabbit 1", R.drawable.rabbit_52,"3"));
        mascotas.add(new Mascota("Rabbit Run 1", R.drawable.running_rabbit_filled_50,"3"));
        mascotas.add(new Mascota("Turtle 1", R.drawable.turtle_52,"4"));
    }
}
