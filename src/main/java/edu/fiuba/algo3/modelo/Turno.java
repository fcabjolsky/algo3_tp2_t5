package edu.fiuba.algo3.modelo;

import java.util.List;

public class Turno extends Observable implements Turneable {

    private final Jugador jugador;
    private final Mapa mapa;

    private final AgregadorDeEnemigos creadorEnemigos;
    private int numeroTurno;


    public Turno(Jugador jugador, Mapa mapa) {
       this.jugador = jugador;
       this.mapa = mapa;
       this.creadorEnemigos = new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigos.json", this.mapa);
       this.numeroTurno = 1;
    }

    private void moverEnemigos() {
        //this.mapa.moverEnemigos();

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
        this.numeroTurno ++;
    }

    public void siguienteTurno() {
        this.creadorEnemigos.obtenerInformacionDeNuevosEnemigos(this.numeroTurno);
        this.moverEnemigos();
        this.defenderseDeEnemigos();
        if (ganoLaPartida()) {
            throw new JuegoGanado();
        }
        this.avanzarTurno();
    }

    public void siguienteTurno2(){
        this.moverEnemigos();
        Pasarela pf = this.mapa.getPasarelaFinal();
        if(pf.contieneEnemigosVivos()){
            pf.daniarJugador(this.jugador);
            pf.eliminarEnemigos();
        }
        mapa.reseteaAlosEnemigos();
        this.numeroTurno++;
    }

    public void insertarEnemigosNuevos(){
        this.creadorEnemigos.obtenerInformacionDeNuevosEnemigos(this.numeroTurno);
    }
}


