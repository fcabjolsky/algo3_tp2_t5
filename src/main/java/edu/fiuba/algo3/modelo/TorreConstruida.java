package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

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
