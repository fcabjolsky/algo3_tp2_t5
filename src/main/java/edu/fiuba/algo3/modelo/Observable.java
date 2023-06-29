package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Observable {

    private final ArrayList<Observador> observadores;

    public Observable() {
        this.observadores = new ArrayList<Observador>();
    }
    public void agregarObservador(Observador observador) {
        if (!this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    public void notificarObservadores(Object argument) {
        for (Observador observador : this.observadores) {
            observador.actualizar(this, argument);
        }
    }

}
