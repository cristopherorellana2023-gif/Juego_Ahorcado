package es.iesquevedo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constantes {
    //esta es para que en el entrada salida no tenga texto verde y sean puros metodos

    //crear un metodo distinto para cada parte del menu, o crear un arraylist con el menu y luego imprimirlo en el entrada salida
    public static final List<String> fichero = new ArrayList<>(Arrays.asList(
            "===== JUEGO DEL AHORCADO =====",
            "1. Marcas de coches",
            "2. Dragon Ball",
            "3. Colores",
            "Nota: si eliges una opción que no está aquí, jugarás a encontrar\n" +
                    "una palabra del tema 'instrumentos de música'",
            "Elige una opción: "
    ));

    }