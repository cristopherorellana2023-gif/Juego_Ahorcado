package es.iesquevedo.Common;

public class NumeroException extends RuntimeException {
    public NumeroException(){
        super(Constantes.ERROR_NUMERO);
    }

    public NumeroException(String message) {
        super(message);
    }
}
