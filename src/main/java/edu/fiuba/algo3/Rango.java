package edu.fiuba.algo3;

import javafx.geometry.Pos;

public class Rango {

    private int radio;
    private final Defensa defensa;


    public Rango(int radio, Defensa defensa) {
        this.radio = radio;
        this.defensa = defensa;
    }

    public boolean estaEnRango(Posicion posicionObjetivo) {
        return this.radio >= defensa.posicion().calcularDistanciaA(posicionObjetivo);
    }
}
