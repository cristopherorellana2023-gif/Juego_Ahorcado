package es.iesquevedo;
import java.io.*;
import java.util.ArrayList;

public class CrearAndLeerFichero {

        public static void guardar(ArrayList<String> lista) {

            try {
                FileWriter fw = new FileWriter("palabras.txt");

                for (int i = 0; i < lista.size(); i++) {
                    fw.write(lista.get(i) + "\n");
                }

                fw.close();
                System.out.println("Fichero guardado");

            } catch (Exception e) {
                System.out.println("Error al guardar");
            }
        }

        public static ArrayList<String> leer() {

            ArrayList<String> lista = new ArrayList<>();

            try {
                BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));

                String linea;

                while ((linea = br.readLine()) != null) {
                    lista.add(linea);
                }

                br.close();

            } catch (Exception e) {
                System.out.println("Error al leer");
            }

            return lista;
        }
    }