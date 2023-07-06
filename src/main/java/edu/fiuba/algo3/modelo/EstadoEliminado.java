package edu.fiuba.algo3.modelo;

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
