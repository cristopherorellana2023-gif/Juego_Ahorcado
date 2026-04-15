package es.iesquevedo.UI;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Common.NumeroException;
import es.iesquevedo.Servicio.GestionGeneradorDeElementos;
import es.iesquevedo.dao.CrearAndLeerFichero;
import es.iesquevedo.Servicio.GestionDiccionarioService;
import es.iesquevedo.Servicio.JuegoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSalida {
    private GestionGeneradorDeElementos service;

    // CONSTRUCTOR
    public EntradaSalida(GestionDiccionarioService service) {
        this.service = service;
    }


    //todoo lo de abajo modificarlo

    // =========================
    // MENU PRINCIPAL
    // =========================

    public void menuPrincipal(JuegoService juego) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.print(Constantes.MENU_PRINCIPAL);
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        // aqui debe ir de lo iniciar una partida nueva
                        break;
                    case 2:
                        //Aqui tiene que ir recuperar lo de la partida anterior
                    case 3:
                        //llamar a un metodo que se encargue de todoo lo que hace el submenu que serael menu_diccionario
                        menuDiccionario();
                        break;

                    case 0:
                        CrearAndLeerFichero.guardar(service.getLista());
                        System.out.println(Constantes.SALIR);
                        break;

                    default:
                        System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }

            } catch (NumeroException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                opcion = -1;
            }

        } while (opcion != 0);
    }







    //el menu del diccionario por aparte simplemente porque asi lo veo mas claro, creo que no es obligatorio hacerlo un
    //submenu dentro del menu principal

    private void menuDiccionario() {

        //pedir contraseña para entrar al diccionario de datos de la clase diccionarioService

        System.out.print(Constantes.PASSWORD);
            String pass = sc.nextLine();

            if (!pass.equals(Constantes.PASSWORD)) {
                System.out.println(Constantes.PASSWORD_CORRECTA);
                return;
            }

        int op;

        do {
            try {
                System.out.print(Constantes.MENU_DICCIONARIO);
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {

                    case 1:
                        //service.listar();
                        break;

                    case 2:
                        //service.insertar(new Elemento(Constantes.INPUT_PALABRA, Constantes.INPUT_CATEGORIA));
                    break;

                    case 3:
                        //service.eliminar(Constantes.INPUT_PALABRA);
                        break;

                    case 4:
                        //service.modificar(Constantes.INPUT_PALABRA, Constantes.INPUT_NUEVA_CATEGORIA);
                        break;

                    case 0:
                       // System.out.println(Constantes.SALIR);
                        break;

                    default:
                        System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }

            } catch (InputMismatchException e) {
                System.out.println(Constantes.ERROR_NUMERO);
                op = -1;
            }

        } while (op != 0);
    }

}
