package edu.fiuba.algo3.modelo;

public abstract class Enemigo extends Observable {
    protected int energia;

    protected int velocidad;

    protected Movible estado;

    protected int danio;

    protected AtaqueEnemigo ataqueEnemigo;
    private EstadoEnemigo estadoEnemigo;

    public Enemigo() {
        this.nuevoEstado(new EstadoVivo());
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
        this.notificarObservadores("Enemigo llego al final");
        return this.estadoEnemigo.atacar();
    }

    public boolean sePuedeMover() {
       return this.estado.puedoSeguirMoviendome();
    }

}
