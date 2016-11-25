package com.lgcs.mascotas.restApi;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tecnologías on 15/11/2016.
 */

public class ConstantesRestApi {
    Context context;

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4140112305.8906a52.d4fa4424de5547208e1653272b621fb5";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



    public static final String KEY_GET_USERS_SEARCH = "users/search?q={nombre}&access_token=";
    //public static final String KEY_ACCESS_TOKEN_UNICO = "&access_token=";

    //SharedPreferences miPreferenciaCompartida = context.getSharedPreferences("CuentaInicial",Context.MODE_PRIVATE);
    //String nombre = miPreferenciaCompartida.getString("nombre","No existe");

    //public static final String URL_GET_SEARCH_USER = KEY_GET_USERS_SEARCH + nombre + KEY_ACCESS_TOKEN_UNICO + ACCESS_TOKEN;



    //https://api.instagram.com/v1/users/self/?access_token=4140112305.8906a52.d4fa4424de5547208e1653272b621fb5
    //https://api.instagram.com/v1/users/search?q=jack&access_token=4140112305.8906a52.d4fa4424de5547208e1653272b621fb5
}
