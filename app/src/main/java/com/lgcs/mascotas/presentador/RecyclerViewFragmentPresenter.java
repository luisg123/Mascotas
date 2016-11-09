package com.lgcs.mascotas.presentador;

import android.content.Context;

import com.lgcs.mascotas.IReclyclerViewFragmentView;
import com.lgcs.mascotas.Mascota;
import com.lgcs.mascotas.MascotaAdaptador;
import com.lgcs.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

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
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iReclyclerViewFragmentView.inicializarAdaptadorRV(iReclyclerViewFragmentView.crearAdaptador(mascotas));
        iReclyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
