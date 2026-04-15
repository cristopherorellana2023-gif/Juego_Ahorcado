package es.iesquevedo.Common;

public class Constantes {
    //esta es para que en el entrada salida no tenga texto verde y sean puros metodos

    //crear un metodo distinto para cada parte del menu, o crear un arraylist con el menu y luego imprimirlo en el entrada salida
        // MENÚ PRINCIPAL
        public static final String MENU_PRINCIPAL =
                "\n--- MENU PRINCIPAL ---\n" +
                 "1. Jugar\n" + "2. Recuperar Partida\n" + "3. Gestionar diccionario\n" + "0. Salir\n" + "Ingresa una Opcion: ";

        // MENÚ DICCIONARIO
    public static final String MENU_DICCIONARIO =
            "\n1. Listar\n2. Insertar\n3. Modificar\n4. Eliminar\n0. Volver\nOpción: ";

        public static final String PASSWORD = "Dime la contraseña: ";
        public static final String PASSWORD_CORRECTA = "¡Contraseña correcta!";
        public static final String FICHERO = "palabras.txt";
        public static final String ERROR_NUMERO = "Debes introducir un número";
        public static final String ERROR_NUMERO_INVALIDO = "Debes introducir un numero entre 0 y 2";
        public static final String ERROR_SOLO_LETRA = "Solo se permite una letra";
        public static final String ERROR_NO_LETRA = "El carácter no es una letra";
        public static final String ERROR_LETRA_REPETIDA = "Esa letra ya fue usada";
        public static final String SALIR = "Saliendo...";
        public static final String INPUT_PALABRA = "Introduce palabra: ";
        public static final String INPUT_CATEGORIA = "Introduce categoría: ";
        public static final String INPUT_NUEVA_CATEGORIA = "Introduce nueva categoría: ";

        public static final String GANASTE = " ¡Has ganado!";
        public static final String PERDISTE = " Has perdido. La palabra era: ";

        public static final String FICHERO_GUARDADO = "Fichero guardado";
        public static final String ERROR_GUARDAR = "Error al guardar";
        public static final String FICHERO_NO_GUARDADO = "Fichero no guardado";
        public static final String ERROR_LEER = "Error al leer";

        public static final String NO_HAY_PALABRAS = "No hay palabras en el diccionario";
    }