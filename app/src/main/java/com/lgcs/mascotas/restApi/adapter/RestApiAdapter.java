package com.lgcs.mascotas.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lgcs.mascotas.db.ConstantesBaseDatos;
import com.lgcs.mascotas.restApi.ConstantesRestApi;
import com.lgcs.mascotas.restApi.EndpointsApi;
import com.lgcs.mascotas.restApi.deserializador.MascotaDeserializador;
import com.lgcs.mascotas.restApi.model.MascotaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tecnologías on 15/11/2016.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)

                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());

        return  gsonBuilder.create();
    }
}
