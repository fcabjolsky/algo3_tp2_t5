package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {


    public TorreBlanca(Posicion posicion) {
        super(1);
        this.rango = new Rango(3, posicion);
    }
}
