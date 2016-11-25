package com.lgcs.mascotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CincoMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinco_mascotas);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        mostrarPreferencia();
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

       /* mascotas.add(new Mascota("Bird 1", R.drawable.bird_48,1));
        mascotas.add(new Mascota("Cat 2", R.drawable.cat_filled_50,16));
        mascotas.add(new Mascota("Dog 1", R.drawable.dog_filled_50,2));
        mascotas.add(new Mascota("Rabbit Run 1", R.drawable.running_rabbit_filled_50,3));
        mascotas.add(new Mascota("Turtle 1", R.drawable.turtle_52,5));*/
    }

    public void mostrarPreferencia(){

        SharedPreferences miPreferenciaCompartida = getSharedPreferences("CuentaInicial", Context.MODE_PRIVATE);

        String nombre = miPreferenciaCompartida.getString("nombre","No existe");

        TextView tvPreferenciaCompartida = (TextView) findViewById(R.id.tvSharedPreference);
        String preferencia = "\n Nombre:" + nombre;
        tvPreferenciaCompartida.setText(preferencia);

    }
}
