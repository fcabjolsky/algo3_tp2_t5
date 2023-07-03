package edu.fiuba.algo3.modelo;

public class EstadoMuerto implements EstadoEnemigo{

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
