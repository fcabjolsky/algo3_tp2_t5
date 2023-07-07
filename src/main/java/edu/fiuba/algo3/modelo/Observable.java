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

    public void agregarObservadores(ArrayList<Observador> observadores) {
        for (Observador observador: observadores) {
            this.agregarObservador(observador);
        }
    }

    public void replicarObservadores(Observable observable) {
        this.agregarObservadores(observable.observadores);
    }

    public void notificarObservadores(Object argument) {
        for (Observador observador : this.observadores) {
            observador.actualizar(this, argument);
        }
    }

    public void notificarObservador(Object argument, int index) {
        observadores.get(index).actualizar(this, argument);
    }

}
