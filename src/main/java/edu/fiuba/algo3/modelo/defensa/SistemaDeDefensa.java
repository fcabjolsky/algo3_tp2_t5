package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.*;

public class SistemaDeDefensa implements Turneable {

    private EstadoSistemaDeDefensa estado;

    private int danio;

    private Rango rango;

    public SistemaDeDefensa(int danio, Rango rango) {
        this.danio = danio;
        this.rango = rango;
        this.nuevoEstado(new EstadoActivado());
    }

    public void nuevoEstado(EstadoSistemaDeDefensa nuevoEstado) {
        this.estado = nuevoEstado;
        this.estado.setSistemaDeDefensa(this);
    }

    public void defender(Enemigo enemigo) {
        this.estado.defender(enemigo, this.danio);
    }

    public boolean estaEnRango(Posicion unaPosicion) {
        return this.rango.estaEnRango(unaPosicion);
    }

    public String obtenerNotificacionAObservadores(Enemigo enemigo) {
        return ("Torre esta atacando a enemigo: " + enemigo.toString() + " con danio: " + this.danio);
    }

    @Override
    public void avanzarTurno() {
        this.estado.avanzarTurno();
    }
}
