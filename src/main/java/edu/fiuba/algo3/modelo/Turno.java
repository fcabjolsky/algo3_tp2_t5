package edu.fiuba.algo3.modelo;

import java.util.List;

public class Turno extends Observable implements Turneable {

    private final Jugador jugador;
    private final Mapa mapa;
    private final AgregadorDeEnemigos creadorEnemigos;
    private ContadorDeTurno contadorDeTurno;


    public Turno(Jugador jugador, Mapa mapa) {
       this.jugador = jugador;
       this.mapa = mapa;
       this.creadorEnemigos = new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", this.mapa);
       this.contadorDeTurno = ContadorDeTurno.obtenerContador();
       this.inicializarContadores();
       this.contadorDeTurno.incrementar();
    }

    private void inicializarContadores() {
        this.contadorDeTurno.resetearContador();
        ContadorDeMuertesDeHormiga.obtenerContador().resetearContador();
    }


    private void moverEnemigos() {
        //this.mapa.moverEnemigos();

        ProcesoDeMovimiento procesoDeMovimiento = new ProcesoDeMovimiento();
        procesoDeMovimiento.procesarMovimiento(this.mapa.obtenerParcelasTransitables());

    }

    private void recolectarRecompensas() {
        List<Transitable> parcelas = this.mapa.obtenerParcelasTransitables();
        for (Transitable parcela : parcelas) {
            this.jugador.sumarCreditos(parcela.recolectarRecompensas());
        }
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
        this.jugador.avanzarTurno();
        this.daniarJugador();
        this.recolectarRecompensas();
    }

    public void siguienteTurno() {
        this.notificarObservadores("Turno: " + this.contadorDeTurno.obtenerValor());
        this.creadorEnemigos.obtenerInformacionDeNuevosEnemigos(this.contadorDeTurno.obtenerValor());
        this.moverEnemigos();
        this.defenderseDeEnemigos();
        if (ganoLaPartida()) {
            throw new JuegoGanado();
        }
        this.avanzarTurno();
        this.contadorDeTurno.incrementar();
    }

    public void daniarJugador(){
        Pasarela pf = this.mapa.getPasarelaFinal();
        if(pf.contieneEnemigosVivos()){
            pf.daniarJugador(this.jugador);
        }
        mapa.reseteaAlosEnemigos();
    }
}


