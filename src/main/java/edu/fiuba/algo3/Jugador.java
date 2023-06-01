package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    int vida = 20;
    int creditos = 100;
    List <Defensa> defensas = new ArrayList();

    public int getVida() {
        return vida;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public boolean puedeConstruir(int costo){
      return costo< this.creditos;
    }
    
    public void construir(Defensa defensa, Posicion posicion) throws Exception{
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
    
    
}
