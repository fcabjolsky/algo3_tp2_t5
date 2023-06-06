package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoTorre;
import edu.fiuba.algo3.modelo.TorreEnConstruccion;

public class Torre implements Defensa {

    protected Rango rango;
    protected int danio;

    private EstadoTorre estado;

    public Torre (int tiempoDeConstruccion){
        estado = new TorreEnConstruccion(tiempoDeConstruccion);
    }

    @Override
    public Defensa construir(Jugador jugador, Posicion posicion) {
        return null;
    }

    @Override
    public void defender(Enemigo enemigo) {
        if(enemigo.estaEnRango(this.rango)) {
            estado.defender(enemigo, this.danio);

        }
        else {
            throw new EnemigoFueraDeRango();
        }
    }

    @Override
    public boolean puedeConstruir(int creditos) {
        return false;
    }


    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }


    public Posicion posicion() {
        return this.rango.posicion();
    }

}
