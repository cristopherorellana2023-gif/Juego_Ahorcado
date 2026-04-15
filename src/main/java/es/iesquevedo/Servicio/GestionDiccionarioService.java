package es.iesquevedo.Servicio;

import es.iesquevedo.Common.Constantes;
import es.iesquevedo.Modelo.Elemento;
import es.iesquevedo.dao.DaoGeneradorDeElementos;

import java.io.*;
import java.util.*;

public class GestionDiccionarioService implements GestionGeneradorDeElementos {

    private List<Elemento> lista;
    private DaoGeneradorDeElementos generador;

    // CONSTRUCTOR
    public GestionDiccionarioService(DaoGeneradorDeElementos generador) {
        this.generador = generador;
        this.lista = new ArrayList<>();
    }



    //ESTOS METODOS SON LOS QUE EXITEN EN LA INTERFAZ, AQUI SOLO SE RELLENAN O S DEVUELVE
    //LO QUE REALEMENTE

    @Override
    public List<Elemento> getListaElementos() {
        return lista;
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return lista.add(elemento);
    }

    @Override
    public void eliminarElemento(Elemento elemento) {
        lista.remove(elemento);
    }

    @Override
    public boolean eliminarElemento(String palabra) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPalabraSecreta().equalsIgnoreCase(palabra)) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Elemento> listar(String categoria) {
        return getListaElementosCategoria(categoria);
    }

    @Override
    public List<Elemento> listarElementos(boolean ascendente) {

        List<Elemento> copia = new ArrayList<>(lista);

        copia.sort((a, b) -> {
            if (ascendente)
                return a.getPalabraSecreta().compareToIgnoreCase(b.getPalabraSecreta());
            else
                return b.getPalabraSecreta().compareToIgnoreCase(a.getPalabraSecreta());
        });

        return copia;
    }

    @Override
    public List<Elemento> getListaElementosCategoria(String categoria) {

        List<Elemento> res = new ArrayList<>();

        for (Elemento e : lista) {
            if (e.getCategoria().equalsIgnoreCase(categoria)) {
                res.add(e);
            }
        }
        return res;
    }

    @Override
    public String getPalabraAdivinar(String categoria) {

        List<Elemento> listaCat = getListaElementosCategoria(categoria);

        if (listaCat.isEmpty()) return null;

        int random = (int) (Math.random() * listaCat.size());

        return listaCat.get(random).getPalabraSecreta();
    }




    @Override
    public boolean modificarElemento(String palabra, String nuevaCategoria) {

        for (Elemento e : lista) {
            if (e.getPalabraSecreta().equalsIgnoreCase(palabra)) {
                e.setCategoria(nuevaCategoria);
                return true;
            }
        }

        return false;
    }




    @Override
    public void crearFicheros() throws IOException {

        File f = new File(Constantes.FICHERO);

        if (!f.exists()) {
            f.createNewFile();
        }
    }

    @Override
    public boolean cargarFichero() throws IOException {

        File f = new File(Constantes.FICHERO);

        if (!f.exists() || f.length() == 0) {
            // primera ejecución, debemos generar datos al menos esta vez
            lista = generador.getElementos();
            escribirFichero();
            return false;
        }

        lista.clear();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] p = linea.split(Constantes.PUNTOYCOMA);
            lista.add(new Elemento(p[0], p[1]));
        }

        br.close();
        return true;
    }

    @Override
    public boolean escribirFichero() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.FICHERO))) {

            for (Elemento e : lista) {
                bw.write(e.getPalabraSecreta() + ";" + e.getCategoria());
                bw.newLine();
            }

            return true;

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_GUARDAR);
            return false;
        }
    }


    //Los ficheros binarios para cuando quiera o cuando elija la opcion
    //de recuperar una partida
    @Override
    public boolean escribirFicheroBinario() {
        // aquí guardarías partida (opcional si aún no lo haces)
        return true;
    }

    @Override
    public boolean cargarFicheroBinario() {
        // aquí cargarías partida
        return true;
    }
}
