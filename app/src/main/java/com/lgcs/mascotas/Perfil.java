package com.lgcs.mascotas;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lgcs.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.lgcs.mascotas.presentador.RecyclerViewFragmentPresenter;
import com.lgcs.mascotas.restApi.EndpointsApi;
import com.lgcs.mascotas.restApi.EndpointsApiSearch;
import com.lgcs.mascotas.restApi.adapter.RestApiAdapter;
import com.lgcs.mascotas.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil  implements IReclyclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    private IReclyclerViewFragmentView iReclyclerViewFragmentView;
    private Context context;

    public Perfil() {
        // Required empty public constructor
    }
    public Perfil(IReclyclerViewFragmentView iReclyclerViewFragmentView, Context context){
        this.iReclyclerViewFragmentView = iReclyclerViewFragmentView;
        this.context = context;
        //obtenerMascotasBaseDatos();
        obtenerUsuarioBuscado();
    }


    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /*View v = inflater.inflate(R.layout.fragment_perfil,container,false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPetsPerf);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        GridLayoutManager glm = new GridLayoutManager(getActivity(),4);

        glm.setOrientation(GridLayoutManager.VERTICAL);

        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();*/

/*
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPetsPerf);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;

    }*/

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador  = new MascotaPerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        /*mascotas.add(new Mascota(R.drawable.bird_48,1));
        mascotas.add(new Mascota(R.drawable.cat_filled_50,16));
        mascotas.add(new Mascota(R.drawable.dog_filled_50,2));
        mascotas.add(new Mascota(R.drawable.running_rabbit_filled_50,3));
        mascotas.add(new Mascota(R.drawable.turtle_52,5));*/
    }


    @Override
    public void generarLinearLayoutVertical() {

    }

    @Override
    public void generarGridLayout() {

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void obtenerUsuarioBuscado() {
        SharedPreferences miPreferenciaCompartida = context.getSharedPreferences("CuentaInicial", Context.MODE_PRIVATE);

        String nombre = miPreferenciaCompartida.getString("nombre","No existe");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApiSearch endpointsApi = (EndpointsApiSearch) restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getSearchUsers(nombre);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un error en la conexión, intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión",t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        iReclyclerViewFragmentView.inicializarAdaptadorRV(iReclyclerViewFragmentView.crearAdaptador(mascotas));
        //iReclyclerViewFragmentView.generarLinearLayoutVertical();
        iReclyclerViewFragmentView.generarGridLayout();
    }
}
