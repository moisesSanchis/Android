package com.mosapl.t5a01sanchisplamoises.pojos;

import java.util.ArrayList;

public class DiscoDatos {
    public static ArrayList<Disco> DISCOS = new ArrayList<Disco>();

    static{
        // Discos
        DISCOS.add(new Disco("Still got the blues", "1990", "Gary Moore"));
        DISCOS.add(new Disco("One night only", "1998", "Bee Gees"));
        DISCOS.add(new Disco("When a man loves a woman", "1987", "Percy Sledge"));
        DISCOS.add(new Disco("Big Willie style", "1997", "Will Smith"));

        // Canciones
        DISCOS.get(0).canciones.add(new Cancion(1, "Still Got the Blues",6.12f));
        DISCOS.get(0).canciones.add(new Cancion(2, "Let Me With the Blues",2.59f));
        DISCOS.get(0).canciones.add(new Cancion(3, "The Sky is Crying",4.52f));
        DISCOS.get(0).canciones.add(new Cancion(4, "Further Up the Road",4.05f));

        DISCOS.get(1).canciones.add(new Cancion(1, "Intro: You Should Be Dancing/Alone",5.47f));
        DISCOS.get(1).canciones.add(new Cancion(2, "Massachusetts",2.32f));
        DISCOS.get(1).canciones.add(new Cancion(3, "To Love Somebody",3.10f));
        DISCOS.get(1).canciones.add(new Cancion(4, "Closer Than Close",6.12f));

        DISCOS.get(2).canciones.add(new Cancion(1, "When a man loves a woman",4.12f));

        DISCOS.get(3).canciones.add(new Cancion(1, "Intro",1.51f));
        DISCOS.get(3).canciones.add(new Cancion(2, "Y'All Know",3.57f));
        DISCOS.get(3).canciones.add(new Cancion(3, "Gettin' Jiggy With It",3.47f));
        DISCOS.get(3).canciones.add(new Cancion(4, "Candy",3.56f));

    }
}
