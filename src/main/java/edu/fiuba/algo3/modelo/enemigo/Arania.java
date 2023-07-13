package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Jugador;

public class Arania extends Enemigo {

    public Arania() {
        super(2, 2,2 , new AtaqueEnemigoNormal());
    }
  
    public int darRecompensa(){
        int recompensa = (int)(Math.random()*10+1);
        return recompensa;
    }

    public void morir(Jugador jugador){
        jugador.sumarCreditos(darRecompensa());
    }

    @Override
    public String toString() {
        return "Arania";
    }

}
