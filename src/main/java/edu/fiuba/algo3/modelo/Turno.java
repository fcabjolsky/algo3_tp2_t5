package edu.fiuba.algo3.modelo;

public class Turno {

    private final Jugador jugador;
    private final Mapa mapa;

    public Turno(Jugador jugador, Mapa mapa) {
       this.jugador = jugador;
       this.mapa = mapa;
    }

    public void moverEnemigos() {
        this.mapa.pasarTurno();
    }

    public boolean ganoLaPartida() {
        return !this.mapa.contieneEnemigos();
    }

}


