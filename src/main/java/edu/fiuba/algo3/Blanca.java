package edu.fiuba.algo3;

public class Blanca extends Torre {

    public Blanca(Posicion posicion) {
        super(posicion);
        this.rango = new Rango(3, this);
    }


}
