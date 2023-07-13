package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Transitable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.EstadoEnemigo;

public class EstadoEliminado implements EstadoEnemigo {

    @Override
    public void setEnemigo(Enemigo enemigo) {}

    @Override
    public void recibirDanio(int unDanio) {}

    @Override
    public void avanzar(Transitable siguienteTransitable) {}

    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public int morir() {
        return 0;
    }

    @Override
    public boolean estaMuerto() {
        return true;
    }
}
