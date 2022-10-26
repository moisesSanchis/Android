package com.mosapl.tema3calculadoramoisessanchis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView pantalla;
    private Button boton9, boton8, boton7, boton6, boton5, boton4, boton3, boton2, boton1, boton0;
    private Button botonSum, botonRest, botonMult, botonDiv, botonIgual, botonPunto, botonC;
    private ArrayList<Button> botones;
    private String textoPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botones = new ArrayList<>();
        textoPantalla = "";
        //Obtenemos una referencia a los controles de la interfaz.
        pantalla = (TextView) findViewById(R.id.tvPantalla);
        pantalla.setText(textoPantalla);
        boton9 = (Button) findViewById(R.id.btnNueve);
        botones.add(boton9);
        boton8 = (Button) findViewById(R.id.btnOcho);
        botones.add(boton8);
        boton7 = (Button) findViewById(R.id.btnSiete);
        botones.add(boton7);
        boton6 = (Button) findViewById(R.id.btnSeis);
        botones.add(boton6);
        boton5 = (Button) findViewById(R.id.btnCinco);
        botones.add(boton5);
        boton4 = (Button) findViewById(R.id.btnCuatro);
        botones.add(boton4);
        boton3 = (Button) findViewById(R.id.btnTres);
        botones.add(boton3);
        boton2 = (Button) findViewById(R.id.btnDos);
        botones.add(boton2);
        boton1 = (Button) findViewById(R.id.btnUno);
        botones.add(boton1);
        boton0 = (Button) findViewById(R.id.btnCero);
        botones.add(boton0);
        botonSum = (Button) findViewById(R.id.btnMas);
        botones.add(botonSum);
        botonRest = (Button) findViewById(R.id.btnMenos);
        botones.add(botonRest);
        botonMult = (Button) findViewById(R.id.btnMultiplicar);
        botones.add(botonMult);
        botonDiv = (Button) findViewById(R.id.btnBarra);
        botones.add(botonDiv);
        botonIgual =(Button) findViewById(R.id.btnIgual);
        botones.add(botonIgual);
        botonPunto = (Button)findViewById(R.id.btnPunto);
        botones.add(botonPunto);
        botonC = (Button) findViewById(R.id.btnC);
        botones.add(botonC);
        anadirListener();

    }


    private void anadirListener() {
        for (Button boton : botones) {
            boton.setOnClickListener(this);
        }
    }


    private void anadirDigito(String digito) {
        textoPantalla += digito;
        pantalla.setText(textoPantalla);
    }
    //Funcion para sumar.
    private void suma(){
        float suma;
        float numero1 = Float.parseFloat(textoPantalla.substring(0,textoPantalla.indexOf("+")));
        float numero2 = Float.parseFloat(textoPantalla.substring(textoPantalla.indexOf("+")+1, textoPantalla.length()));
        suma = numero1 + numero2;
        textoPantalla = String.valueOf(suma);

    }
    //Funcion para restar.
    private void resta(){
        float resta;
        float numero1 = Float.parseFloat(textoPantalla.substring(0,textoPantalla.indexOf("-")));
        float numero2 = Float.parseFloat(textoPantalla.substring(textoPantalla.indexOf("-")+1, textoPantalla.length()));
        resta = numero1 - numero2;
        textoPantalla = String.valueOf(resta);

    }

    //Funcion para multiplicar.
    private void multiplicacion(){
        float multiplicacion;
        float numero1 = Float.parseFloat(textoPantalla.substring(0,textoPantalla.indexOf("*")));
        float numero2 = Float.parseFloat(textoPantalla.substring(textoPantalla.indexOf("*")+1, textoPantalla.length()));
        multiplicacion = numero1 * numero2;
        textoPantalla = String.valueOf(multiplicacion);
    }

    //Funcion para dividir.
    private void division(){
        float division;
        float numero1 = Float.parseFloat(textoPantalla.substring(0,textoPantalla.indexOf("/")));
        float numero2 = Float.parseFloat(textoPantalla.substring(textoPantalla.indexOf("/")+1, textoPantalla.length()));
        division = numero1 / numero2;
        textoPantalla = String.valueOf(division);

    }

    private void calcular(){
        if( textoPantalla.contains("+"))
            suma();
        if (textoPantalla.contains("-"))
            resta();
        if (textoPantalla.contains("*"))
            multiplicacion();
        if (textoPantalla.contains("/"))
            division();

        pantalla.setText(textoPantalla);
    }



    //Funcion para mostrar la operacion concatenada a los numeros.
    private void mostrarOperacion(String operacion){
        textoPantalla += operacion;
        pantalla.setText(textoPantalla);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNueve:
                anadirDigito("9");
                break;
            case R.id.btnOcho:
                anadirDigito("8");
                break;
            case R.id.btnSiete:
                anadirDigito("7");
                break;
            case R.id.btnSeis:
                anadirDigito("6");
                break;
            case R.id.btnCinco:
                anadirDigito("5");
                break;
            case R.id.btnCuatro:
                anadirDigito("4");
                break;
            case R.id.btnTres:
                anadirDigito("3");
                break;
            case R.id.btnDos:
                anadirDigito("2");
                break;
            case R.id.btnUno:
                anadirDigito("1");
                break;
            case R.id.btnCero:
                anadirDigito("0");
                break;
            case R.id.btnMas:
                mostrarOperacion("+");
                break;
            case R.id.btnMenos:
                mostrarOperacion("-");
                break;
            case R.id.btnMultiplicar:
                mostrarOperacion("*");
                break;
            case R.id.btnBarra:
                mostrarOperacion("/");
                break;
            case R.id.btnC:
                textoPantalla = "";
                pantalla.setText(textoPantalla);
                break;
            case R.id.btnPunto:
                anadirDigito(".");
                break;
            case R.id.btnIgual:
                calcular();
                break;
        }
    }
}