package es.iesquevedo.Modelo;

import java.io.*;
import java.util.ArrayList;

public class Juego implements Serializable {

    private String palabra;
    private ArrayList<Character> PALABRAOCULTAARRAY;
    private int intentos;



    public Juego(String palabra) {

        this.palabra = palabra.toUpperCase();
        this.intentos = 6;
        this.PALABRAOCULTAARRAY = new ArrayList<>();

        for (int i = 0; i < palabra.length(); i++) {
            PALABRAOCULTAARRAY.add('_');
        }
    }


    // GETTER
    public String getPalabra() {
        return palabra;
    }

    public ArrayList<Character> getPALABRAOCULTAARRAY() {
        return PALABRAOCULTAARRAY;
    }

    public int getIntentos() {
        return intentos;
    }

    public void fallo(){
        intentos--;
    }

    public void guardarPalabraOculta(char c){
        PALABRAOCULTAARRAY.add(c);
    }
}
