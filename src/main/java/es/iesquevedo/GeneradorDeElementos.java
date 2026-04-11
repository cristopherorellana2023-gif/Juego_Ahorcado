package es.iesquevedo;

import net.datafaker.Faker;
import java.util.ArrayList;

public class GeneradorDeElementos{

    public static ArrayList<String> generarPalabras(int opcion) {

        Faker faker = new Faker();
        ArrayList<String> palabras = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            String palabra = "";

            switch (opcion) {
                case 1:
                    palabra = faker.vehicle().make(); // coches
                    break;
                case 2:
                    palabra = faker.dragonBall().character();
                    break;
                case 3:
                    palabra = faker.color().name(); // colores
                    break;
                default:
                    palabra = faker.music().instrument(); //instrumentos de musica
                    break;
            }


            palabra = palabra.replace(" ", "").toLowerCase();

            palabras.add(palabra);
        }

        switch(opcion) {
            case 1:
                System.out.println("Generando marcas de coches...");
                break;
            case 2:
                System.out.println("Generando nombres de Dragon Ball...");
                break;
            case 3:
                System.out.println("Generando colores...");
                break;
            default:
                System.out.println("Generando instrumentos de Musica...");
                break;
        }
        return palabras;
    }
}