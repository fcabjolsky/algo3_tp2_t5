package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EstadoVivo implements EstadoEnemigo {

    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    @Override
    public void recibirDanio(int unDanio) {
        this.enemigo.energia -= unDanio;
        this.enemigo.notificarObservadores("Enemigo recibe danio " + unDanio + ", vida restante " + this.enemigo.energia);
        if (this.enemigo.energia <= 0) {
            this.enemigo.nuevoEstado(new EstadoMuerto());
        }
    }

    @Override
    public void avanzar(Transitable siguienteTransitable) {
        this.enemigo.estado = this.enemigo.estado.moverA(this.enemigo, siguienteTransitable);
    }

    @Override
    public int atacar() {
        this.enemigo.nuevoEstado(new EstadoEliminado());
        return this.enemigo.ataqueEnemigo.atacar(this.enemigo.danio);
    }

    @Override
    public int morir() {
        return 0;
    }

    @Override
    public boolean estaMuerto() {
        return false;
    }

}
