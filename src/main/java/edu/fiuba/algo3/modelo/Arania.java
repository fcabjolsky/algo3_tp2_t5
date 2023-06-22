package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania() {
        this.energia = 2;
        this.velocidad = 2;
        this.estado = new EnMovimiento(this.velocidad);
    }
  
    private int darRecompensa(){
        int recompensa = (int)(Math.random()*10+1);
        return recompensa;
    }

    public void morir(Jugador jugador, Contador muertesDeArañas){
        jugador.sumarCreditos(darRecompensa());
    }

    

}
