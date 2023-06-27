package edu.fiuba.algo3.modelo;

import java.util.List;

public class Turno extends Observable implements Turneable {

    private final Jugador jugador;
    private final Mapa mapa;
    private AgregadorDeEnemigos creadorEnemigos;
    private int numeroDeTurno;

    public Turno(Jugador jugador, Mapa mapa) {
       this.jugador = jugador;
       this.mapa = mapa;
       this.creadorEnemigos = new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigos.json", this.mapa);
       this.numeroDeTurno = 1;
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

    public void avanzarTurno() {
        this.mapa.avanzarTurno();
        this.jugador.avanzarTurno();//ac
        this.numeroDeTurno ++;
    }

    public void siguienteTurno() {
        this.creadorEnemigos.obtenerInformacionDeNuevosEnemigos(this.numeroDeTurno);
        this.moverEnemigos();
        this.defenderseDeEnemigos();
        if (ganoLaPartida()) {
            throw new JuegoGanado();
        }
        this.avanzarTurno();
    }
}


