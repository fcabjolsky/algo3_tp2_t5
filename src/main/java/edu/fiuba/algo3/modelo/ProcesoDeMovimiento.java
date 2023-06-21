package edu.fiuba.algo3.modelo;

import java.util.List;

public class ProcesoDeMovimiento {

    public void procesarMovimiento(List<Transitable> parcelasTransitables) {

        for (int i = 0; i < parcelasTransitables.size() - 1; i++) {
            Transitable parcelaTransitable = parcelasTransitables.get(i);
            parcelaTransitable.moverEnemigosA(parcelasTransitables.get(i + 1));
        }
    }
}
