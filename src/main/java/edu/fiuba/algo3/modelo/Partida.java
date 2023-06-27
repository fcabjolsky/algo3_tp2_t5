package edu.fiuba.algo3.modelo;

public class Partida extends Observable implements Turneable{

    private final Mapa mapa; //esto podria salir de aca y estar dentro de Turno directamente

    private final Jugador jugador;
    private Observador logger;
    private Turno turno;
    private CreadorMapaJson creadorMapa;


    public Partida(Mapa mapa, Jugador jugador) {//hace alusion al empezarPartida, que el jugador tenga una partida en vez de un turno, a la que le diga avanzarTurno
    	this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
    }

    public Partida(Mapa mapa, Jugador jugador, Observador logger) {
        this.logger = logger;
        this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
        this.agregarObservador(logger);
        turno.agregarObservador(this.logger);
    }

    public Partida(Jugador jugador, Observador logger) {
        this.jugador = jugador;
        this.creadorMapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json");
        this.mapa = this.creadorMapa.crearMapa();
        this.turno = new Turno(this.jugador, this.mapa);
        this.agregarObservador(logger);
        turno.agregarObservador(this.logger);
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
        this.setearCambiado();
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
            this.setearCambiado();
            this.notificarObservadores("Ganaste");
        }

    }
}
