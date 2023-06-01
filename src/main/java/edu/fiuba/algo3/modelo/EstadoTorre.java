package edu.fiuba.algo3.modelo;

public interface EstadoTorre {

    void defender(Enemigo enemigo);
    EstadoTorre avanzarTurno();
}
