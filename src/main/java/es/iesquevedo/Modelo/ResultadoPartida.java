package es.iesquevedo.Modelo;

import java.io.Serializable;

public class ResultadoPartida implements Serializable {
    private String palabra;
    private boolean ganado;
    private int intentosRestantes;
    private int intentosTotales;

    public ResultadoPartida(String palabra, boolean ganado, int intentosRestantes, int intentosTotales) {
        this.palabra = palabra;
        this.ganado = ganado;
        this.intentosRestantes = intentosRestantes;
        this.intentosTotales = intentosTotales;
    }

    public int getIntentosUsados() {
        return intentosTotales - intentosRestantes;
    }

    public void mostrarResumen() {
        System.out.println("\n--- ÚLTIMA PARTIDA ---");
        System.out.println("Palabra        : " + palabra);
        System.out.println("Resultado      : " + (ganado ? "GANASTE" : "PERDISTE"));
        System.out.println("Intentos usados: " + getIntentosUsados());
        System.out.println("________________________");
    }
}
