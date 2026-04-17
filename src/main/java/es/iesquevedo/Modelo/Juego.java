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
        this.intentos = 6;

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