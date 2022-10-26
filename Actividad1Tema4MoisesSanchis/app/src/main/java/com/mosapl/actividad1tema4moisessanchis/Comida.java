package com.mosapl.actividad1tema4moisessanchis;

public class Comida {
    private String nombre;
    private String origen;
    private int foto;
    private String url;

    public Comida(String nombre, String origen, int foto, String url) {
        this.nombre = nombre;
        this.origen = origen;
        this.foto = foto;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
