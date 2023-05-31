package edu.fiuba.algo3;

public class Rango {

    private int radio;

    private int getRadio() {
        return this.radio;
    }

    public Rango(int radio) {
        this.radio = radio;
    }

    public boolean estaEnRango(Posicion posicionOrigen, Posicion posicionDestino) {
        return this.getRadio() >= posicionOrigen.calcularDistanciaA(posicionDestino);
    }
}
