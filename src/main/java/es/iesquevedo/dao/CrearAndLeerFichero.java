package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import es.iesquevedo.Modelo.Juego;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrearAndLeerFichero {

//ficheros cuando se cree un nuevo juego

    public static void guardar(List<Elemento> lista) {

        try {
            FileWriter fw = new FileWriter(Constantes.FICHERO);

            for (Elemento e : lista) {
                fw.write(e.toString() + "\n");
            }

            fw.close();
            System.out.println(Constantes.FICHERO_GUARDADO);

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_GUARDAR);
        }
    }

    public static ArrayList<Elemento> leer() {

        ArrayList<Elemento> lista = new ArrayList<>();
        File fichero = new File(Constantes.FICHERO);

        // Si no existe devolver la lista vacia
        if (!fichero.exists() || fichero.length() == 0) {
            return lista;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));

            String linea;

            while ((linea = br.readLine()) != null) {

                // toString palabra ; categoria
                String[] partes = linea.split(Constantes.PUNTOYCOMA);

                if (partes.length == 2) {
                    String palabra = partes[0];
                    String categoria = partes[1];

                    lista.add(new Elemento(palabra, categoria));
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_LEER);
        }
        return lista;
    }






    // Ficheros binarios para cuando se elija vovler a cargar una partida anterior

    public static void guardarResultado(Juego juego) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(Constantes.FICHERO_BINARIO))) {
            oos.writeObject(juego);
            System.out.println(Constantes.FICHERO_GUARDADO);
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_GUARDAR);
        }
    }

    public static Juego leerResultado() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constantes.FICHERO_BINARIO));
            Juego juego = (Juego) ois.readObject();
            ois.close();
            System.out.println("Partida cargada correctamente");
            return juego;
        } catch (FileNotFoundException e) {
            System.out.println("No hay partida guardada");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la partida");
        }
        return null;
    }

}