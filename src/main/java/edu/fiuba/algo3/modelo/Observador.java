package edu.fiuba.algo3.modelo;

public interface Observador {
    public abstract void actualizar(Observable observable, Object argument);
}
