package edu.fiuba.algo3.modelo;

public class Contador {
    int actual = 0;

    public void aumentar(){
        actual += 1;
    }

    public boolean esMayorA(int numero){
        return this.actual > numero;
    }

}
