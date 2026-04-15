package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import net.datafaker.Faker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeElementos {

    private List<Elemento> elementos;

    public GeneradorDeElementos() {

        File file = new File(Constantes.FICHERO);

        // Si existe fichero cargarlo
        if (file.exists()) {

            elementos = CrearAndLeerFichero.leer();

        } else {

            // Si no existe -> generar con Faker
            elementos = new ArrayList<>();
            Faker faker = new Faker();

            for (int opcion = 1; opcion <= 4; opcion++) {

                String categoria = "";
                String mensaje = "";

                switch (opcion) {
                    case 1:
                        categoria = "PELICULAS";
                        mensaje = "Generando películas...";
                        break;
                    case 2:
                        categoria = "SIMPSONS";
                        mensaje = "Generando personajes de los Simpsons...";
                        break;
                    case 3:
                        categoria = "PALABRAS";
                        mensaje = "Generando palabras...";
                        break;
                    case 4:
                        categoria = "FRASES";
                        mensaje = "Generando frases...";
                        break;
                }

                //luego cambiarlo por metodos cada palabra que esta en verde porque se ve feo ahi
                System.out.println(categoria);
                System.out.println(mensaje);

                for (int i = 0; i < 5; i++) {

                    String palabra = "";

                    switch (opcion) {
                        case 1:
                            palabra = faker.animal().name();
                            break;
                        case 2:
                            palabra = faker.simpsons().character();
                            break;
                        default:
                            System.out.println(Constantes.ERROR_NUMERO_INVALIDO);;
                    }

                    // limpiar palabra
                    palabra = palabra.replace(" ", "").toUpperCase();

                    elementos.add(new Elemento(palabra, categoria));
                }
            }
        }
    }

    public List<Elemento> getElementos() {
        return elementos;
    }
}