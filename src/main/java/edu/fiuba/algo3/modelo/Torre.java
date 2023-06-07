package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoTorre;
import edu.fiuba.algo3.modelo.TorreEnConstruccion;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Torre implements Defensa {

    public Rango rango;
    protected int danio;

    private EstadoTorre estado;
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
    public void defender(Mapa mapa) {
        this.estado.defender(mapa, this.danio, this.rango);
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }


    @Override
    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }


    public Posicion posicion() {
        return this.rango.posicion();
    }


}
