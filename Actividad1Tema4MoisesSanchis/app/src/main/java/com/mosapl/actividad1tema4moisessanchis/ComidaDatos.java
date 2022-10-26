package com.mosapl.actividad1tema4moisessanchis;

import java.util.ArrayList;

public class ComidaDatos {
    static ArrayList<Comida> COMIDAS = new ArrayList<>();

    static {
        COMIDAS.add(new Comida("pizza", "Italia", R.drawable.pizza, "https://es.wikipedia.org/wiki/Pizza"));
        COMIDAS.add(new Comida("paella", "España", R.drawable.paella, "https://es.wikipedia.org/wiki/Paella"));
        COMIDAS.add(new Comida("Kebab", "Turquia", R.drawable.kebab, "https://es.wikipedia.org/wiki/Kebab"));
        COMIDAS.add(new Comida("Hamburguesa", "Estados Unidos", R.drawable.burger, "https://es.wikipedia.org/wiki/Hamburguesa"));
        COMIDAS.add(new Comida("Pasta", "Italia", R.drawable.pasta, "https://es.wikipedia.org/wiki/Pasta"));





    }
}
