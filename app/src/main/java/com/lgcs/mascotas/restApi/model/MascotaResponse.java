package com.lgcs.mascotas.restApi.model;

import com.lgcs.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by Tecnologías on 15/11/2016.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
