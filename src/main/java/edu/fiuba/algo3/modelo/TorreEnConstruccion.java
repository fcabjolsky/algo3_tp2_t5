package edu.fiuba.algo3.modelo;

public class TorreEnConstruccion implements EstadoTorre {

    private int numeroDeTurno;
    private int tiempoDeConstruccion;

    public TorreEnConstruccion(int tiempoDeConstruccion){
        numeroDeTurno = 0;
        this.tiempoDeConstruccion= tiempoDeConstruccion;
    }

    @Override
    public void defender(Enemigo enemigo) {
        throw new DefensaNoOperativa();
    }

    @Override
    public EstadoTorre avanzarTurno() {
        numeroDeTurno++;
        if(numeroDeTurno >= tiempoDeConstruccion){
            return new TorreConstruida();
        }else{
            return this;
        }
    }
}
