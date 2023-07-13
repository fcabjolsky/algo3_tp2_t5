package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.ContadorDeTurno;
import edu.fiuba.algo3.modelo.enemigo.AtaqueEnemigo;

public class AtaqueEnemigoSegunParidadDeTurno implements AtaqueEnemigo {

    private boolean TurnoEsPar() {
        return ((ContadorDeTurno.obtenerContador().obtenerValor() % 2) == 0);
    }

    @Override
    public int atacar(int unDanio) {
        if(this.TurnoEsPar()){
            return unDanio;
        }
        return (unDanio + 3);
    }
}
