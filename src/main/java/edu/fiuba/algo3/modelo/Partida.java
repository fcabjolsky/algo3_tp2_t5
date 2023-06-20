package edu.fiuba.algo3.modelo;

public class Partida extends Observable {

    private final Mapa mapa;

    private final Jugador jugador;
    private Observador logger;

    private Turno turno;

    public Partida(Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
    }
    public Partida(Mapa mapa, Jugador jugador, Observador logger) {
        this.logger = logger;
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
        turno.agregarObservador(this.logger);
    }

    public String juegoGanado() {
        this.setearCambiado();
        if (this.turno.ganoLaPartida()) {
            this.notificarObservadores("Ganaste");
            return "GANASTE";
        }
        this.notificarObservadores("Seguir Jugando");
        return "SEGUIR JUGANDO";
    }

}
