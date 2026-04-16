package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrearAndLeerFichero {

//ficheros cuando se cree un nuevo juego

    public static void guardar(ArrayList<Elemento> lista) {

        try {
            FileWriter fw = new FileWriter(Constantes.FICHERO);

            for (Elemento e : lista) {
                fw.write(e.toStringFichero() + "\n");
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

        // Si no existe devolver la lista vacía
        if (!fichero.exists()) {
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






    /// Ficheros binarios para cuando se elija vovler a cargar una partida anterior
    public static void crearFicheroBinario(ArrayList<Elemento> lista) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constantes.FICHERO));
                    oos.writeObject(lista);
                    oos.close();
                    System.out.println(Constantes.FICHERO_GUARDADO);

        } catch (Exception e) {
            System.out.println(Constantes.ERROR_GUARDAR);
        }
    }

    public static List<Elemento> leerFicheroBinario() {
        List<Elemento> palabras = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constantes.FICHERO))){
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
}