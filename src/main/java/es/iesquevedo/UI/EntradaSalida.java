package es.iesquevedo.UI;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Servicio.GestionDiccionarioService;
import es.iesquevedo.Modelo.Juego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSalida {

    private GestionDiccionarioService dicService;
    private Juego juegoService;


    // CONSTRUCTOR
    public EntradaSalida(GestionDiccionarioService dicService, Juego juegoService) {
        this.dicService = dicService;
        this.juegoService = juegoService;
    }

    // MENU PRINCIPAL
    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.print(Constantes.MENU_PRINCIPAL);
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        menuJugar();
                        break;

                    case 2:
                        // recuperar partida
                        break;

                    case 3:
                        menuDiccionario();
                        break;

                    case 0:
                        System.out.println(Constantes.SALIR);
                        break;

                    default:
                        System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número");
                sc.nextLine();
                opcion = -1;
            }

        } while (opcion != 0);
    }



    //MENU PARA CUANDO SELECCIONE JUGAR
    private void menuJugar() {
    Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.print(Constantes.MENU_OPCION_JUGAR);
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        // iniciar partida con el fichero de los animales
                        break;

                    case 2:
                        // iniciar partida con el fichero de los simpsons
                        // break;

                    case 0:
                        System.out.println(Constantes.SALIR);
                        break;

                    default:
                        System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ERROR_NUMERO);
                sc.nextLine();
                opcion = -1;
            }

        } while (opcion != 0);
    }





    // MENU DICCIONARIO (ADMIN)
    private void menuDiccionario() {
    Scanner sc = new Scanner(System.in);


        System.out.print(Constantes.PASSWORD);
        String pass = sc.nextLine();

        if (!pass.equals(Constantes.PASSWORD)) {
            System.out.println(Constantes.PASSWORD_INCORRECTA);
            return;
        }

        int opcion;

        do {
            try {
                System.out.print(Constantes.MENU_DICCIONARIO);
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        // listar diccionario
                        break;

                    case 2:
                        // insertar elemento
                        break;

                    case 3:
                        // modificar elemento
                        break;

                    case 4:
                        // eliminar elemento
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ERROR_NUMERO);
                sc.nextLine();
                opcion = -1;
                //Esto sirve para asegurarnos de que sea disitinto de 0, que se yo si alguien mete 01-02-03
                // y por alguna razon lo lee
            }

        } while (opcion != 0);
    }
}
