package edu.fiuba.algo3.modelo;

public class Partida {

    private final Mapa mapa;

    private final Jugador jugador;

    private Turno turno;

    public Partida(Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
    }
    public void jugar() {
        while (!this.turno.ganoLaPartida()) {
            this.turno
        }
    }
    public String juegoGanado() {
        if (this.turno.ganoLaPartida()) {
            return "GANASTE";
        }
        return "SEGUIR JUGANDO";
    }

}
