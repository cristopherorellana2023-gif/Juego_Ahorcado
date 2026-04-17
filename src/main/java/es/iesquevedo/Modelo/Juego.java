package es.iesquevedo.Modelo;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Juego implements Serializable {

    private String palabra;
    private char[] incognita;
    private int intentos;

    public Juego(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.incognita = new char[palabra.length()];
        this.intentos = incognita.length;

        Arrays.fill(incognita, '_');
    }


    public void partida(Scanner sc) {
        while (intentos > 0 && !ganado()) {
            mostrarEstado();
            char letra = pedirLetra(sc);
            if (!probarLetra(letra)) {
                intentos--;
                System.out.println("Fallo");
            } else {
                System.out.println("Acierto");
            }
        }
        mostrarResultado();
    }


    //nos falta hacer un arraylist para las letras usadas, para mostrarlo en la partida, bueno aunque en
    //el java fx tenia una variable que era de nivel de dificultad tambien, seguramente tendremos que hacerla
    private void mostrarEstado() {
        System.out.println("\nPalabra: " + String.valueOf(incognita));
        System.out.println("Intentos restantes: " + intentos);
        System.out.println("Letras usadas: " );
    }

    private char pedirLetra(Scanner sc) {
        System.out.print("Introduce una letra: ");
        String input = sc.nextLine().toUpperCase();
        while (input.isEmpty() || !Character.isLetter(input.charAt(0))) {
            System.out.print("Introduce una letra válida: ");
            input = sc.nextLine().toUpperCase();
        }
        return input.charAt(0);
    }
    //hecho para que se guarde el resultado de la partida para saber que ha salido
    public boolean isGanado() {
        return palabra.equals(String.valueOf(incognita));
    }

    public int getIntentos() {
        return intentos;
    }

    public String getPalabra() {
        return palabra;
    }


    // Metodo para probar si la letra está en la palabra y actualizar el estado del juego
    private boolean probarLetra(char letra) {
        boolean acierto = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                incognita[i] = letra;
                acierto = true;
            }
        }

        return acierto;
    }
    //metodo que cuando la palabra esta completamente destapada, el juego se da por ganado
    private boolean ganado() {
        return palabra.equals(String.valueOf(incognita));
    }

    private void mostrarResultado() {
        if (ganado()) {
            System.out.println("Has ganado! Palabra: " + palabra);
        } else {
            System.out.println("Has perdido! Palabra: " + palabra);
        }
    }
}