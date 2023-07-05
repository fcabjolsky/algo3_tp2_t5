package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania() {
        super();
        this.energia = 2;
        this.velocidad = 2;
        this.estado = new EnMovimiento(this.velocidad);
        this.ataqueEnemigo = new AtaqueEnemigoNormal();
        this.danio = 2;
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
