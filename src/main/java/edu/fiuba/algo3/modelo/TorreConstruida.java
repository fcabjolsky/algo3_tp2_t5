package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class TorreConstruida extends Observable implements EstadoTorre {

    @Override
    public void defender(Enemigo enemigo, int danio) {
        this.notificarObservadores("Torre esta atacando a enemigo: " + enemigo.toString() + " con danio: " + danio);
        enemigo.recibirDanio(danio);
    }

    @Override
    public EstadoTorre avanzarTurno() {
        return this;
    }
}
