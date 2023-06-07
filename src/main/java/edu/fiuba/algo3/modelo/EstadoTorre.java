package edu.fiuba.algo3.modelo;

public interface EstadoTorre {

    void defender(Mapa enemigo, int danio, Rango rango);
    EstadoTorre avanzarTurno();
}
