package com.mosapl.tema4app02;

import java.util.ArrayList;

public class TareaDatos {
    static ArrayList<Tarea> TAREAS = new ArrayList<>();
    static{
        TAREAS.add(new Tarea("Correr 30 minutos","08:00"));
        TAREAS.add(new Tarea("Estudiar móviles","10:00"));
        TAREAS.add(new Tarea("Comer 4 rebanadas de manzana","10:30"));
        TAREAS.add(new Tarea("Asistir al taller de programación","15:45"));
        TAREAS.add(new Tarea("Quedar con Belén","18:00"));
    }

}
