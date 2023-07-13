package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.enemigo.AtaqueEnemigo;

public class AtaqueEnemigoNormal implements AtaqueEnemigo {

    @Override
    public int atacar(int unDanio) {
        return unDanio;
    }
}
