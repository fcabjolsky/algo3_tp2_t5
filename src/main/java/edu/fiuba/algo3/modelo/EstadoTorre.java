package edu.fiuba.algo3.modelo;

public interface EstadoTorre {

    void defender(Enemigo enemigo, int danio);

    EstadoTorre avanzarTurno();
}
