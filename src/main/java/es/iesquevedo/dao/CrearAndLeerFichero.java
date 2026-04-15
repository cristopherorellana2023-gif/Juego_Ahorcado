package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrearAndLeerFichero {

    public static void guardar(ArrayList<Elemento> lista) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("palabras.txt"));
                    oos.writeObject(lista);
                    oos.close();
                    System.out.println("Fichero guardado");

        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public static List<Elemento> leer() {
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