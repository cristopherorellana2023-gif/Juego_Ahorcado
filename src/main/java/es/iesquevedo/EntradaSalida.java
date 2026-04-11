package es.iesquevedo;
import java.util.Scanner;

public class EntradaSalida {

    public static int mostrarMenu() {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < Constantes.fichero.size(); i++) {
            System.out.println(Constantes.fichero.get(i));
        }

        return sc.nextInt();
    }

}
