package edu.fiuba.algo3.modelo;

public class TrampaArena extends Observable implements Defensa {

    public TrampaArena(Posicion posicion){

    }
    @Override
    public Defensa construir(Jugador jugador) {
        return this;
    }

    @Override
    public void defender(Enemigo enemigo) {

    }

    @Override
    public boolean puedeConstruir(int creditos) {
        return true;
    }

    @Override
    public void avanzarTurno() {

    }

    @Override
    public boolean estaEnRango(Posicion unaPosicion) {
        return false;
    }
}
