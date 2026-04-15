package es.iesquevedo.Servicio;

import es.iesquevedo.Modelo.Elemento;

import java.io.IOException;
import java.util.List;

public interface GestionGeneradorDeElementos {

    public List<Elemento> getListaElementos();
    public boolean insertarElemento(Elemento elemento);
    public String getPalabraAdivinar(String categoria);
    public List<Elemento> listar(String categoria);
    public List<Elemento> listarElementos(boolean ascendente);
    public boolean modificarElemento(String id, String incognita);
    public List<Elemento> getListaElementosCategoria(String categoria);
    public void eliminarElemento(Elemento elemento);
    public void crearFicheros()throws IOException;
    public boolean cargarFichero() throws IOException;
    public boolean escribirFichero();
    public boolean escribirFicheroBinario();
    public boolean cargarFicheroBinario();
    public boolean eliminarElemento(String id);
}
