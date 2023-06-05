package edu.fiuba.algo3;

public class Blanca extends Torre {

    public Blanca(Posicion posicion) {
        this.rango = new Rango(3, posicion);
    }

    public boolean puedeConstruir(int creditos) {
        return true;
    }

    @Override
    public Defensa construir(Jugador jugador, Posicion posicion) {
        return null;
    }
}
