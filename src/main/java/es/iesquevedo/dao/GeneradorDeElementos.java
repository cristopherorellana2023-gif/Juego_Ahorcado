package es.iesquevedo.dao;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import net.datafaker.Faker;

import java.io.File;
import java.util.*;

public class GeneradorDeElementos implements DaoGeneradorDeElementos {

    private List<Elemento> elementos;

    public GeneradorDeElementos() {

        File file = new File(Constantes.FICHERO);

        if (file.exists() && file.length() > 0) {
            elementos = CrearAndLeerFichero.leer();

        } else {

            elementos = new ArrayList<>();
            Faker faker = new Faker();

            for (int opcion = 1; opcion <= 2; opcion++) {

                String categoria = "";
                String mensaje = "";

                switch (opcion) {
                    case 1:
                        categoria = "ANIMALES";
                        mensaje = "Generando animales...";
                        break;
                    case 2:
                        categoria = "SIMPSONS";
                        mensaje = "Generando personajes de los Simpsons...";
                        break;
                }

                System.out.println(mensaje);

                for (int i = 0; i < 5; i++) {

                    String palabra = "";

                    switch (opcion) {
                        case 1:
                            palabra = faker.animal().name();
                            break;
                        case 2:
                            palabra = faker.simpsons().character();
                            break;
                    }

                    palabra = limpiarPalabra(palabra);

                    elementos.add(new Elemento(palabra, categoria));
                }
            }


            CrearAndLeerFichero.guardar(elementos);
        }
    }

    private String limpiarPalabra(String palabra) {
        return palabra
                .toUpperCase().replaceAll(" ", "");
    }



    @Override
    public boolean isEmptyElementosList() {
        return elementos.isEmpty();
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        boolean res = elementos.add(elemento);
        CrearAndLeerFichero.guardar(elementos);
        return res;
    }


    @Override
    public List<Elemento> getElementos() {
        return elementos;
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {

        List<Elemento> filtrados = new ArrayList<>();

        for (Elemento e : elementos) {
            if (e.getCategoria().equalsIgnoreCase(categoria)) {
                filtrados.add(e);
            }
        }

        return filtrados;
    }

    @Override
    public List<Elemento> listadoOrdenado(boolean ascendente) {

        List<Elemento> copia = new ArrayList<>(elementos);

        copia.sort(Comparator.comparing(Elemento::getPalabraSecreta));

        if (!ascendente) {
            Collections.reverse(copia);
        }

        return copia;
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {

        if (id >= 0 && id < elementos.size()) {
            elementos.get(id).setCategoria(categoria);
            CrearAndLeerFichero.guardar(elementos);
            return true;
        }

        return false;
    }

    @Override
    public boolean modificarElemento(int id, String palabra) {

        if (id >= 0 && id < elementos.size()) {
            elementos.get(id).setPalabraSecreta(palabra);
            CrearAndLeerFichero.guardar(elementos);
            return true;
        }

        return false;
    }

    @Override
    public void eliminarElemento(Elemento elemento) {
        elementos.remove(elemento);
        CrearAndLeerFichero.guardar(elementos);
    }

    @Override
    public boolean eliminarElemento(int id) {

        if (id >= 0 && id < elementos.size()) {
            elementos.remove(id);
            CrearAndLeerFichero.guardar(elementos);
            return true;
        }

        return false;
    }

    @Override
    public String getPalabraAdivinar(String categoria) {

        List<Elemento> lista = getElementosCategoria(categoria);

        if (lista.isEmpty()) return null;

        Random r = new Random();
        return lista.get(r.nextInt(lista.size())).getPalabraSecreta();
    }
}