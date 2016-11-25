package com.lgcs.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lgcs.mascotas.IReclyclerViewFragmentView;
import com.lgcs.mascotas.Mascota;
import com.lgcs.mascotas.MascotaAdaptador;
import com.lgcs.mascotas.db.ConstructorMascotas;
import com.lgcs.mascotas.restApi.EndpointsApi;
import com.lgcs.mascotas.restApi.adapter.RestApiAdapter;
import com.lgcs.mascotas.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tecnologías on 25/10/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IReclyclerViewFragmentView iReclyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IReclyclerViewFragmentView iReclyclerViewFragmentView, Context context){
        this.iReclyclerViewFragmentView = iReclyclerViewFragmentView;
        this.context = context;
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi =  restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();
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
