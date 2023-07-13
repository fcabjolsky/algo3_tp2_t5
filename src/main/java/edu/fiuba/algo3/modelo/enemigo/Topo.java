package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Contador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Transitable;

public class Topo extends Enemigo {
    Contador cantidadMovimientos;
    public Topo(){
        super(2, 1,1 , new AtaqueEnemigoSegunParidadDeTurno());
        this.cantidadMovimientos = new Contador();
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

    @Override
    public String toString() {
        return "Topo";
    }
}
