package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre{

    public TorrePlateada (Posicion posicion){
        super(2);
        this.rango = new Rango(5, posicion);
    }
}
