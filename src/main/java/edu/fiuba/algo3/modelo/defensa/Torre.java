package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public abstract class Torre extends Observable implements Defensa, Turneable {
    protected EstadoTorre estado;
    protected int costo;
    //private final int tiempoDeConstruccion;
    protected int tiempoDeConstruccion;
    protected SistemaDeDefensa sistemaDeDefensa;

    public Torre (int tiempoDeConstruccion, int costo, SistemaDeDefensa sistemaDeDefensa){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.nuevoEstado(new TorreEnConstruccion());
        this.costo = costo;
        this.sistemaDeDefensa = sistemaDeDefensa;
    }

    protected void empezarAConstruir() {
        TorreEnConstruccion torreEnConstruccion = new TorreEnConstruccion();
        torreEnConstruccion.replicarObservadores(this);
        this.nuevoEstado(torreEnConstruccion);
    }

    public void nuevoEstado(EstadoTorre nuevoEstado) {
        this.estado = nuevoEstado;
        this.estado.setTorre(this);
    }

    @Override
    public void defender(Enemigo enemigo) {
        this.estado.defender(enemigo);
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }

    @Override
    public void avanzarTurno(){
        this.estado.avanzarTurno();
        this.sistemaDeDefensa.avanzarTurno();
    }

    public boolean estaEnRango(Posicion unaPosicion) {
        return this.sistemaDeDefensa.estaEnRango(unaPosicion);
    }
}


