package edu.fiuba.algo3.modelo;

import java.util.List;

public class Turno extends Observable {

    private final Jugador jugador;
    private final Mapa mapa;

    public Turno(Jugador jugador, Mapa mapa) {
       this.jugador = jugador;
       this.mapa = mapa;
    }

    private void moverEnemigos() {
        ProcesoDeMovimiento procesoDeMovimiento = new ProcesoDeMovimiento();
        procesoDeMovimiento.procesarMovimiento(this.mapa.obtenerParcelasTransitables());
    }


    public boolean ganoLaPartida() {
        return !this.mapa.contieneEnemigos();
    }

    private void defenderseDeEnemigos() {
        ProcesoDeDefensa procesoDeDefensa = new ProcesoDeDefensa();
        procesoDeDefensa.procesarDefensa(this.mapa.obtenerPasarelasConEnemigos(), this.jugador.obtenerDefensas());

    }

    private void construirDefensas() {
        List<Defensa> defensas = this.jugador.obtenerDefensas();
        for (Defensa defensa: defensas) {
            defensa.avanzarTurno();
        }
    }

    public void siguienteTurno() {
        this.moverEnemigos();
        this.defenderseDeEnemigos();
        if (ganoLaPartida()) {
            throw new JuegoGanado();
        }
        this.construirDefensas();
    }
}


