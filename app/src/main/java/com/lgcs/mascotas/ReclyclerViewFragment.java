package com.lgcs.mascotas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tecnologías on 01/08/2016.
 */
public class ReclyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_reclyclerview,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
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
