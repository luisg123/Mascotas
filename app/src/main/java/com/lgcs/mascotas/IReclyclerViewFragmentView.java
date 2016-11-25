package com.lgcs.mascotas;

import java.util.ArrayList;

/**
 * Created by Tecnologías on 11/10/2016.
 */

public interface IReclyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();


    public MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void obtenerUsuarioBuscado();
    public void mostrarMascotasRV();

}
