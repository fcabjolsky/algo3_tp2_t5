package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    private ContadorDeMuertesDeHormiga contadorDeMuertesDeArania;

    public Arania() {
        this.energia = 2;
        this.velocidad = 2;
        this.estado = new EnMovimiento(this.velocidad);
        this.danio = 2;
    }
  
    private int darRecompensa(){
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
