package es.iesquevedo.Servicio;

import es.iesquevedo.dao.DaoGeneradorDeElementos;
import es.iesquevedo.Modelo.Elemento;

import java.io.IOException;
import java.util.*;

public class GestionDiccionarioService implements GestionGeneradorDeElementos {
    //UN ATIRUBUTO QUE SEA ARRAY DE OBJETO DaoGeneradorDeElementos

    private DaoGeneradorDeElementos lista;

    @Override
    public boolean isEmptyElementosList() {
        return false;
    }

    @Override
    public List<Elemento> getListaElementos() {
        return List.of();
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return false;
    }

    @Override
    public String getPalabraAdivinar(String categoria) {
        return "";
    }

    @Override
    public List<Elemento> listar(String categoria) {
        return List.of();
    }

    @Override
    public List<Elemento> listarElementos(boolean ascendente) {
        return List.of();
    }

    @Override
    public boolean modificarElemento(String id, String incognita) {
        return false;
    }

    @Override
    public List<Elemento> getListaElementosCategoria(String categoria) {
        return List.of();
    }

    @Override
    public void eliminarElemento(Elemento elemento) {

    }

    @Override
    public void crearFicheros() throws IOException {

    }

    @Override
    public boolean cargarFichero() throws IOException {
        return false;
    }

    @Override
    public boolean escribirFichero() {
        return false;
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }

    @Override
    public boolean eliminarElemento(String id) {
        return false;
    }
}
