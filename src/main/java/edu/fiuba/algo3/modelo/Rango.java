package edu.fiuba.algo3.modelo;


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
