package edu.fiuba.algo3.modelo;


public class Partida extends Observable implements Turneable{
    private Turno turno;
    public Partida(Turno turno) {
        this.turno = turno;
    }

    public boolean ganoPartida() {
        return this.turno.ganoLaPartida();
    }

    public String juegoGanado() {
        if (this.turno.ganoLaPartida()) {
            this.notificarObservadores("Ganaste");
            return "GANASTE";
        }
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
