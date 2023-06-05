package edu.fiuba.algo3.modelo;

public class TorreConstruida implements EstadoTorre{

    @Override
    public void defender(Enemigo enemigo, int danio) {
        enemigo.recibirDanio(danio);
    }

    @Override
    public EstadoTorre avanzarTurno() {
        return this;
    }
}
