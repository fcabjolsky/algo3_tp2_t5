package edu.fiuba.algo3.modelo;

public class Partida extends Observable {
    private Mapa mapa;
    private final Jugador jugador;
    private Observador logger;
    private Turno turno;
    private CreadorMapaJson creadorMapa;

    public Partida(Mapa mapa, Jugador jugador) {
    	this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
    }

    public Partida(Jugador jugador){
        this.jugador = jugador;
    }

    public Partida(Mapa mapa, Jugador jugador, Observador logger) {
        this.logger = logger;
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
        this.agregarObservador(logger);
        turno.agregarObservador(this.logger);
    }
    /*public void jugar() {
        while (!this.turno.ganoLaPartida()) {
            this.turno;
        }
    }*/

    public String juegoGanado() {
        this.setearCambiado();
        if (this.turno.ganoLaPartida()) {
            this.notificarObservadores("Ganaste");
            return "GANASTE";
        }
        this.notificarObservadores("Seguir Jugando");
        return "SEGUIR JUGANDO";
    }


    public Turno empezarPartida() {
        this.creadorMapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json");
        this.mapa = this.creadorMapa.crearMapa();
        this.turno = new Turno(this.jugador, this.mapa);
        return this.turno;
    }
}
