package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo{
    Contador cantidadMovimientos;
    public Topo(){
        super();
        this.cantidadMovimientos = new Contador();
        this.velocidad = 1;
        this.estado = new EnMovimiento(this.velocidad);
        this.ataqueEnemigo = new AtaqueEnemigoSegunParidadDeTurno();
        this.danio = 2;
        this.energia = 1;
    }

    @Override
    public void recibirDanio(int unDanio) {
    }

    @Override
    public void morir(Jugador jugador) {
    }

    @Override
    public int darRecompensa() {
        return 0;
    }

    @Override
    public void avanzar(Transitable siguienteTransitable){
        this.estado = this.estado.moverA(this, siguienteTransitable);
        this.cantidadMovimientos.incrementar();
        if(this.cantidadMovimientos.esMayorA(5)  && this.cantidadMovimientos.esMenorA(11)) {
            this.velocidad = 2;
        }
        if(this.cantidadMovimientos.esMayorA(11)){
            this.velocidad = 3;
        }
    }

    public void restaurarVelocidad(){ this.velocidad=1; }
}
