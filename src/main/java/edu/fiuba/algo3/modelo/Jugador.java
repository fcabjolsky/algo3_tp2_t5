package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    int vida = 20;
    int creditos = 100;
    List <Defensa> defensas = new ArrayList();

    public Jugador() {
    }

    public Jugador(int vida, int creditos) {
        this.vida = vida;
        this.creditos = creditos;
    }

    public int getVida() {
        return vida;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public boolean puedeConstruir(int costo){
      return costo< this.creditos;
    }
    
    public void construir(Defensa defensa, Posicion posicion){
        if (defensa.puedeConstruir(this.creditos)) {
            Defensa nuevaDefensa = defensa.construir(this, posicion);
            defensas.add(nuevaDefensa);
        }
        else{
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    public void sumarCreditos(int creditos){
        this.creditos += creditos;
    }

    public void perderVida(int danio){
        this.vida -= danio;
    }


    public boolean equals(Object jugador) {
        Jugador jugadorComparado = (Jugador)jugador;
        if (this.creditos == jugadorComparado.creditos && this.vida == jugadorComparado.vida){
            return true;
        }
        return false;
    }

}
