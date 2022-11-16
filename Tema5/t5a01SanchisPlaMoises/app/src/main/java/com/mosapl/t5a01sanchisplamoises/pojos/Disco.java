package com.mosapl.t5a01sanchisplamoises.pojos;

import java.io.Serializable;
import java.util.ArrayList;

public class Disco implements Serializable {
    private String titulo;
    private String year;
    private String grupo;
    public ArrayList<Cancion> canciones;

    public Disco(String titulo, String year, String grupo) {
        this.titulo = titulo;
        this.year = year;
        this.grupo = grupo;
        this.canciones = new ArrayList<Cancion>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Cancion> getCanciones() { return canciones; }
}
