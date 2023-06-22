package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoTorre;
import edu.fiuba.algo3.modelo.TorreEnConstruccion;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Torre implements Defensa {

    protected Rango rango;
    protected int danio;

    protected EstadoTorre estado;
    protected int costo;

    public Torre (int tiempoDeConstruccion, int costo, int danio){
        this.estado = new TorreEnConstruccion(tiempoDeConstruccion);
        this.costo = costo;
        this.danio = danio;
    }

    public int getCosto() {
        return this.costo;
    }

    @Override
    public void defender(Enemigo enemigo) {
        this.estado.defender(enemigo, this.danio);
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }


    @Override
    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }

    public boolean estaEnRango(Posicion unaPosicion) {
        return this.rango.estaEnRango(unaPosicion); //esto podria pasar a ser responsabilidad de la defensa directamente
    }

    public Rango rango(){
        return this.rango;
    }
}


