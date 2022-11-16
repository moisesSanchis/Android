package com.mosapl.t5a01sanchisplamoises.pojos;

public class Cancion {
    private int id;
    private String titulo;
    private float duracion;

    public Cancion( int id, String titulo, float duracion) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String toString(){
        return "Titulo Cancion: "+ this.id +".- " +this.titulo+"\tduracion: "+this.duracion+" minutos";
    }
}
