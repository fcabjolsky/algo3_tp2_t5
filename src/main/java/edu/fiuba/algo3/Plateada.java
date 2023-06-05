package edu.fiuba.algo3;

public class Plateada extends Torre {

    public Plateada(Posicion posicion) {
        this.rango = new Rango(5, posicion);
    }

    public boolean puedeConstruir(int creditos){
        return true;
    }

    @Override
    public Defensa construir(Jugador jugador, Posicion posicion) {
        return null;
    }
}
