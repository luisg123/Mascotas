package com.lgcs.mascotas;

/**
 * Created by Tecnologías on 07/07/2016.
 */
public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int megusta;
    private String raza;

    public Mascota(String nombre, int foto, int megusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.megusta = megusta;
    }

    public Mascota(int foto, int megusta) {
        this.foto = foto;
        this.megusta = megusta;
    }

    public Mascota() {

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

    public int getMegusta() {
        return megusta;
    }

    public void setMegusta(int megusta) {
        this.megusta = megusta;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
