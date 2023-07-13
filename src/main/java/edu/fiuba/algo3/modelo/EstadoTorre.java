package edu.fiuba.algo3.modelo;

public interface EstadoTorre {

    void defender(Pasarela pasarela, int danio);

    EstadoTorre avanzarTurno();
}
