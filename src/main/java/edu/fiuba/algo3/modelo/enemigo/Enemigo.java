package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.*;

public abstract class Enemigo extends Observable {
    protected int energia;

    protected int velocidad;

    protected Movible estado; //esto en un futuro puede ser un State dentro de Movimiento, ya que es un estado del mismo

    protected int danio;

    protected AtaqueEnemigo ataqueEnemigo;
    private EstadoEnemigo estadoEnemigo;

    public Enemigo(int danio, int velocidad, int energia, AtaqueEnemigo ataqueEnemigo) {
        this.danio = danio;
        this.velocidad = velocidad;
        this.energia = energia;
        this.ataqueEnemigo = ataqueEnemigo;
        this.nuevoEstado(new EstadoVivo());
        this.estado = new EnMovimiento(velocidad);
    }

    public void nuevoEstado(EstadoEnemigo nuevoEstado) {
        this.estadoEnemigo = nuevoEstado;
        this.estadoEnemigo.setEnemigo(this);
    }

    public void recibirDanio(int unDanio) {
        this.estadoEnemigo.recibirDanio(unDanio);
    }

    public boolean estaMuerta() {
        return this.estadoEnemigo.estaMuerto();
    }

    public abstract void morir(Jugador jugador);

    public int morir() {
        return this.estadoEnemigo.morir();
    }

    public abstract int darRecompensa();

    public void avanzar(Transitable siguienteTransitable) {
        this.estadoEnemigo.avanzar(siguienteTransitable);
    }

    public void avanzarTurno() {
        this.estado = new EnMovimiento(this.velocidad);
    }

    public int atacar(){
        return this.estadoEnemigo.atacar();
    }

    public boolean sePuedeMover() {
       return this.estado.puedoSeguirMoviendome();
    }
}
