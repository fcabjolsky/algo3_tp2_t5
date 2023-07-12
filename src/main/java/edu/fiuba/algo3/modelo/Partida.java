package edu.fiuba.algo3.modelo;


public class Partida extends Observable implements Turneable{
    private Mapa mapa;
    private final Jugador jugador;
    private Observador logger;
    private Turno turno;
    private CreadorMapaJson creadorMapa;

    public Partida(Jugador jugador){
        this.jugador = jugador;
    }

    public Partida(Mapa mapa, Jugador jugador, Observador logger) {
        this.logger = logger;
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));
    }

    public Partida(Jugador jugador, Mapa mapa, Turno turno) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.turno = turno;
    }

    private void agregarObservadores() {
        if (this.logger == null) {
            return;
        }
        this.agregarObservador(this.logger);
        this.mapa.agregarObservador(this.logger);
        turno.agregarObservador(this.logger);
    }

    public boolean ganoPartida() {
        return this.turno.ganoLaPartida();
    }
    public String jugar() {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            try {
                this.turno.siguienteTurno();
            } catch (JuegoGanado juegoGanado) {
                return this.juegoGanado();
            }
        }
        return "ERROR";
    }

    public String juegoGanado() {
        if (this.turno.ganoLaPartida()) {
            this.notificarObservadores("Ganaste");
            return "GANASTE";
        }
        this.notificarObservadores("Seguir Jugando");
        return "SEGUIR JUGANDO";
    }

    @Override
    public void avanzarTurno() {
        try {
            this.turno.siguienteTurno();
        } catch (JuegoGanado juegoGanado) {
            this.notificarObservadores("Ganaste");
        }
    }
}
