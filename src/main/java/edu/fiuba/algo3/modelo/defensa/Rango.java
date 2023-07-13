package edu.fiuba.algo3.modelo.defensa;


import edu.fiuba.algo3.modelo.Posicion;

public class Rango {
    private int radio;
    private final Posicion posicion;


    public Rango(int radio, Posicion posicion) {
        this.radio = radio;
        this.posicion = posicion;

    }

    public Posicion posicion() {
        return this.posicion;
    }

    public boolean estaEnRango(Posicion posicionObjetivo) {
        return this.radio >= this.posicion.calcularDistanciaA(posicionObjetivo);
    }
}
