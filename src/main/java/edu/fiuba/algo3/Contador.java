package edu.fiuba.algo3;

public class Contador {

    int actual = 0;

    public void aumentar(){
        actual += 1;
    }

    public boolean esIgual(int numero){
        return this.actual == numero;
    }
}
