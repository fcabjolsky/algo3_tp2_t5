package edu.fiuba.algo3.modelo;

public interface EstadoTorre {

    void defender(Mapa mapa, int danio, Rango rango);
    EstadoTorre avanzarTurno();
}
