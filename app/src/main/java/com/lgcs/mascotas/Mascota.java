package com.lgcs.mascotas;

/**
 * Created by Tecnologías on 07/07/2016.
 */
public class Mascota {
    private String nombre;
    private int foto;
    private String megusta;
    private String raza;

    public Mascota(String nombre, int foto, String megusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.megusta = megusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getMegusta() {
        return megusta;
    }

    public void setMegusta(String megusta) {
        this.megusta = megusta;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


}
