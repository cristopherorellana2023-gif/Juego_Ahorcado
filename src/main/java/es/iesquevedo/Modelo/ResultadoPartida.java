package es.iesquevedo.Modelo;

import java.io.Serializable;

public class ResultadoPartida implements Serializable {
    private String palabra;
    private boolean ganado;
    private int intentosRestantes;

    public ResultadoPartida(String palabra, boolean ganado, int intentosRestantes) {
        this.palabra = palabra;
        this.ganado = ganado;
        this.intentosRestantes = intentosRestantes;
    }

    public String toString() {
        return "Palabra: " + palabra +
                " | Resultado: " + (ganado ? "GANADO" : "PERDIDO") +
                " | Intentos restantes: " + intentosRestantes;
    }
}
