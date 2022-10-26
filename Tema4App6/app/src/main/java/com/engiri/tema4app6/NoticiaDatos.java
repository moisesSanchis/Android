package com.engiri.tema4app6;

import java.util.ArrayList;
import java.util.List;

public class NoticiaDatos {

    static ArrayList<Noticia> NOTICIAS = new ArrayList<Noticia>();

    static{

        NOTICIAS.add(new Noticia("Noticia 1", "Asunto de la noticia 1"));
        NOTICIAS.add(new Noticia("Noticia 2", "Asunto de la noticia 2"));
        NOTICIAS.add(new Noticia("Noticia 3", "Asunto de la noticia 3"));
        NOTICIAS.add(new Noticia("Noticia 4", "Asunto de la noticia 4"));
        NOTICIAS.add(new Noticia("Noticia 5", "Asunto de la noticia 5"));
    }
}
