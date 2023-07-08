package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class TorreConstruida extends Observable implements EstadoTorre {

    @Override
    public void defender(Pasarela pasarela, int danio) {
        this.notificarObservadores(pasarela);
        pasarela.obtenerEnemigoADaniar().recibirDanio(danio);
    }

    @Override
    public EstadoTorre avanzarTurno() {
        return this;
    }
}
