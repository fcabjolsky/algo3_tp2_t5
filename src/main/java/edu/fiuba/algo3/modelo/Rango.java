package edu.fiuba.algo3.modelo;

public class Rango {
    private int radio;

    private int getRadio() {
        return this.radio;
    }

    public Rango(int radio) {
        this.radio = radio;
    }

    public boolean estaEnRango(Posicion posicion) {
        return true;
    }
}
