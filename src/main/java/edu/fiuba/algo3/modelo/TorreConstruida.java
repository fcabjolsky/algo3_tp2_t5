package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class TorreConstruida implements EstadoTorre{

    @Override
    public void defender(Mapa mapa, int danio, Rango rango) {
        List<Enemigo> enemigos = mapa.obtenerEnemigosEnRango(rango);
        enemigos = enemigos
                .stream()
                .filter(enemigo -> !enemigo.estaMuerta())
                .collect(Collectors.toList());
        if (!enemigos.isEmpty()) {
            enemigos.get(0).recibirDanio(danio);
        }
    }

    @Override
    public EstadoTorre avanzarTurno() {
        return this;
    }
}
