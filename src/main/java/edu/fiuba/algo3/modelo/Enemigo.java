package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    protected int energia;
    protected int velocidad;
    protected Movible estado;
    protected int danio;

    public void recibirDanio(int unDanio) {
        if (this.estaMuerta()) {
            throw new EnemigoMuerto();
        }
        this.energia -= unDanio;
    }

    public boolean estaMuerta() {
        return this.energia <= 0;
    }

    public abstract void morir(Jugador jugador, Contador cantidadDeMuertes);

    public void avanzar(Transitable siguienteTransitable) {
        this.estado.moverA(this, siguienteTransitable);
        if(!this.estado.puedoSeguirMoviendome()) {
            this.estado = new Inmovilizado();
        }
    }

    public void avanzarTurno() {
        this.estado = new EnMovimiento(this.velocidad);
    }

    public int atacar(){
        return this.danio;
    }

}
