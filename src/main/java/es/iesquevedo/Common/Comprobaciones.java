package es.iesquevedo.Common;

public class Comprobaciones {

    public static void validarLetra(String input) throws LetraInvalidaException {
        if (input.length() != 1)
            throw new LetraInvalidaException("Solo puedes introducir una letra");

        if (! Character.isLetter(input.charAt(0)))
            throw new LetraInvalidaException("Debe ser una letra");
    }
}
