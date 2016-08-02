package com.lgcs.mascotas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public Perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil,container,false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPetsPerf);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager glm = new GridLayoutManager(getActivity(),4);

        glm.setOrientation(GridLayoutManager.VERTICAL);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador  = new MascotaPerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bird_48,"1"));
        mascotas.add(new Mascota(R.drawable.cat_filled_50,"16"));
        mascotas.add(new Mascota(R.drawable.dog_filled_50,"2"));
        mascotas.add(new Mascota(R.drawable.running_rabbit_filled_50,"3"));
        mascotas.add(new Mascota(R.drawable.turtle_52,"5"));
    }

}
