package es.iesquevedo.UI;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import es.iesquevedo.Modelo.ResultadoPartida;
import es.iesquevedo.Servicio.GestionDiccionarioService;
import es.iesquevedo.Modelo.Juego;
import es.iesquevedo.dao.CrearAndLeerFichero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSalida {

    private GestionDiccionarioService dicService;
    private Scanner sc = new Scanner(System.in);

    public EntradaSalida(GestionDiccionarioService dicService) {
        this.dicService = dicService;
    }

    public void menuPrincipal() {
        int opcion;
        do {
            try {
                System.out.print(Constantes.MENU_PRINCIPAL);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1: menuJugar(); break;
                    case 2:
                        ResultadoPartida resultado = CrearAndLeerFichero.leerResultado();
                        if (resultado != null) {
                            resultado.mostrarResumen();
                        }
                        break;
                    case 3: menuDiccionario(); break;
                    case 0: System.out.println(Constantes.SALIR); break;
                    default: System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número");
                sc.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);
    }

    private void menuJugar() {
        int opcion;
        do {
            try {
                System.out.print(Constantes.MENU_OPCION_JUGAR);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        String palabra1 = dicService.getPalabraAdivinar("ANIMALES");
                        if (palabra1 == null) { System.out.println(Constantes.NO_HAY_PALABRA); break; }
                        new Juego(palabra1).partida(sc);
                        break;
                    case 2:
                        String palabra2 = dicService.getPalabraAdivinar("SIMPSONS");
                        if (palabra2 == null) { System.out.println(Constantes.NO_HAY_PALABRA); break;
                        }
                        new Juego(palabra2).partida(sc);
                        break;
                    case 0: System.out.println(Constantes.SALIR); break;
                    default: System.out.println(Constantes.ERROR_NUMERO_INVALIDO);
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
                        // LISTAR DICCIONARIO
                        System.out.println("DICCIONARIO:");

                        for (Elemento e : dicService.getListaElementos()) {
                            System.out.println(e);
                        }
                        break;

                    case 2:
                        // INSERTAR
                        System.out.print("Palabra: ");
                        String palabra = sc.nextLine();

                        System.out.print("Categoria: ");
                        String categoria = sc.nextLine();

                        boolean insertado = dicService.insertarElemento(
                                new Elemento(palabra, categoria)
                        );

                        if (insertado) {
                            System.out.println("Insertado correctamente");
                        } else {
                            System.out.println("Error al insertar");
                        }
                        break;

                    case 3:
                        // MODIFICAR
                        System.out.print("Palabra a modificar: ");
                        String antigua = sc.nextLine();

                        System.out.print("Nueva palabra: ");
                        String nueva = sc.nextLine();

                        boolean modificado = dicService.modificarElemento(antigua, nueva);

                        if (modificado) {
                            System.out.println("Modificado correctamente");
                        } else {
                            System.out.println("No encontrado");
                        }
                        break;


                    case 4:
                        // ELIMINAR
                        System.out.print("Palabra a eliminar: ");
                        String eliminar = sc.nextLine();

                        boolean eliminado = dicService.eliminarElemento(eliminar);

                        if (eliminado) {
                            System.out.println("Eliminado correctamente");
                        } else {
                            System.out.println(Constantes.ELIMINAR_ELEMENTO);
                        }
                        break;

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
                //Esto sirve para asegurarnos de que sea disitinto de 0, que se yo si alguien mete 01-02-03
                // y por alguna razon lo lee
            }

        } while (opcion != 0);

    }

}
