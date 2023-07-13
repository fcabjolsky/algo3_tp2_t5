package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Transitable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.EstadoEliminado;
import edu.fiuba.algo3.modelo.enemigo.EstadoEnemigo;

public class EstadoMuerto implements EstadoEnemigo {

    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

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
        this.enemigo.nuevoEstado(new EstadoEliminado());
        return this.enemigo.darRecompensa();
    }

    @Override
    public boolean estaMuerto() {
        return true;
    }

}
