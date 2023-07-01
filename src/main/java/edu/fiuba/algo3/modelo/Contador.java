package edu.fiuba.algo3.modelo;

public class Contador {

    protected int valor;

    public void incrementar() {
        valor++;
    }

    public boolean esMayorA(int unValor) {
        return this.valor > unValor;
    }

    public boolean esMenorA(int numero) {return this.valor < numero;}

    public void resetearContador() {
        this.valor = 0;
    }

}
