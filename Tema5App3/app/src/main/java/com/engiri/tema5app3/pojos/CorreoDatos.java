package com.engiri.tema5app3.pojos;

import com.engiri.tema5app3.R;

import java.util.ArrayList;

public class CorreoDatos {

    public static ArrayList<Correo> CORREOS = new ArrayList<Correo>();

    static{
        CORREOS.add(new Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"));
        CORREOS.add(new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"));
        CORREOS.add(new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"));
        CORREOS.add(new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"));
        CORREOS.add(new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5"));
    }

}
