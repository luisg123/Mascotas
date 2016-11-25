package com.lgcs.mascotas.restApi;

import com.lgcs.mascotas.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tecnologías on 24/11/2016.
 */

public interface EndpointsApiSearch {

    @GET(ConstantesRestApi.KEY_GET_USERS_SEARCH)
    //Call<MascotaResponse> getSearchUsers();
    Call<MascotaResponse> getSearchUsers(@Path("nombre") String nombre);


}


    /*@GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId);*/
