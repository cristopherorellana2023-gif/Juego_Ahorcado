package es.iesquevedo.Common;

public class CategoriaNoValidaException extends Exception {
    public CategoriaNoValidaException() {
        super("La categoria ingresada no es valida...");
    }

    public CategoriaNoValidaException(String mensagem) {
        super(mensagem);
    }
}
