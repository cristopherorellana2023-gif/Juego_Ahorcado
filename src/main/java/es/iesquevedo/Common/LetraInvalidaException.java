package es.iesquevedo.Common;

public class LetraInvalidaException extends Exception {
  public LetraInvalidaException() {
    super("La letra ingresada no es valida...");
  }


  public LetraInvalidaException(String msg) {
    super(msg);
  }
}
