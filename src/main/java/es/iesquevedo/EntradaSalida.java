package es.iesquevedo;
import java.util.Scanner;

public class EntradaSalida {

    public static int mostrarMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== JUEGO DEL AHORCADO =====");
        System.out.println("1. Marcas de coches");
        System.out.println("2. Dragon Ball");
        System.out.println("3. Colores");
        System.out.println("Nota: si elijes una opcion que no está aqui, jugaras a encontrar " +
                "\n una palabra del tema 'instrumentos de musica'");
        System.out.print("Elige una opción: ");

        return sc.nextInt();
    }
}
