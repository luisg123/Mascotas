package com.lgcs.mascotas;

import java.sql.Struct;

/**
 * Created by Tecnologías on 07/07/2016.
 */
public class Mascota {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int megusta;

    /*public Mascota(String nombre, int foto, int megusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.megusta = megusta;
    }*/

    public Mascota(String urlFoto, String nombreCompleto, int megusta) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.megusta = megusta;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getMegusta() {
        return megusta;
    }

    public void setMegusta(int megusta) {
        this.megusta = megusta;
    }
}
