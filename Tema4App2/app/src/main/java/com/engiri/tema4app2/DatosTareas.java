package com.engiri.tema4app2;

import java.util.ArrayList;
import java.util.List;

public class DatosTareas {

    static List TAREAS = new ArrayList<Tarea>();

    static{

        TAREAS.add(new Tarea("Correr 30 minutos","08:00"));
        TAREAS.add(new Tarea("Estudiar móviles","10:00"));
        TAREAS.add(new Tarea("Comer 4 rebanadas de manzana","10:30"));
        TAREAS.add(new Tarea("Asistir al taller de programación","15:45"));
        TAREAS.add(new Tarea("Quedar con Belen","18:00"));

    }
}
