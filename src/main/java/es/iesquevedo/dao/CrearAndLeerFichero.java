package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import es.iesquevedo.Modelo.ResultadoPartida;

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
    public static void crearFicheroBinario(List<Elemento> lista) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constantes.FICHERO_BINARIO));
                    oos.writeObject(lista);
                    oos.close();
                    System.out.println(Constantes.FICHERO_GUARDADO);

        } catch (Exception e) {
            System.out.println(Constantes.ERROR_GUARDAR);
        }
    }

    public static List<Elemento> leerFicheroBinario() {
        List<Elemento> palabras = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constantes.FICHERO_BINARIO))){
            palabras = (List<Elemento>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println(Constantes.FICHERO_NO_GUARDADO);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return palabras;
    }

    public static void guardarResultado(ResultadoPartida resultado) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(Constantes.FICHERO_BINARIO))) {
            oos.writeObject(resultado);
            System.out.println(Constantes.FICHERO_GUARDADO);
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_GUARDAR);
        }
    }

    public static ResultadoPartida leerResultado() {
        File f = new File(Constantes.FICHERO_BINARIO);
        if (!f.exists() || f.length() == 0) {
            System.out.println(Constantes.NO_HAY_FICHERO);
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ResultadoPartida) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(Constantes.FICHERO_NO_GUARDADO);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(Constantes.ERROR_LEER);
        }
        return null;
    }

}