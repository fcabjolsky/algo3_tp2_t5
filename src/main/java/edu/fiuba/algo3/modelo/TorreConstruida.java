package edu.fiuba.algo3.modelo;

public class TorreConstruida implements EstadoTorre{

    @Override
    public void defender(Enemigo enemigo) {
        enemigo.recibirDanio();
    }

    @Override
    public EstadoTorre avanzarTurno() {
        return this;
    }
}
