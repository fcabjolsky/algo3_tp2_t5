package edu.fiuba.algo3.modelo;

public abstract class Enemigo extends Observable {
    protected int energia;
    protected int velocidad;
    protected Movible estado;
    protected int danio;

    public void recibirDanio(int unDanio) {
        if (this.estaMuerta()) {
            throw new EnemigoMuerto();
        }
        this.energia -= unDanio;
        this.notificarObservadores("Enemigo " + this.toString() + " recibe danio " + unDanio + " Vida restante " + this.energia);
    }

    public boolean estaMuerta() {
        return this.energia <= 0;
    }

    public abstract void morir(Jugador jugador, Contador cantidadDeMuertes);

    public void avanzar(Transitable siguienteTransitable) {
        this.estado = this.estado.moverA(this, siguienteTransitable);
    }

    public void avanzarTurno() {
        this.estado = new EnMovimiento(this.velocidad);
    }

    public int atacar(int numeroTurno){
        return this.danio;
    }

    public boolean sePuedeMover() {
       return this.estado.puedoSeguirMoviendome();
    }
}
