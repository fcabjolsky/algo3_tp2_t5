package edu.fiuba.algo3;

public class Plateada extends Torre {

    public Plateada(Posicion posicion) {
        super(posicion);
        this.rango = new Rango(5, this);
    }

}
