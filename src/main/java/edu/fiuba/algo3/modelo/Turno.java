package edu.fiuba.algo3.modelo;

import java.util.List;

public class Turno extends Observable {

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

    public void defenderseDeEnemigos() {
        List<Defensa> defensas = this.jugador.obtenerDefensas();
        for (Defensa defensa: defensas) {
            defensa.defender(this.mapa);
        }
    }

    public void construirDefensas() {
        List<Defensa> defensas = this.jugador.obtenerDefensas();
        for (Defensa defensa: defensas) {
            defensa.avanzarTurno();
        }
    }

    public int getJugador(){
        return this.jugador.getVida();
    }
}


