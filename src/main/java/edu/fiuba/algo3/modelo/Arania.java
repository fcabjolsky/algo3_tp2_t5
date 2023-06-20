package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania(Posicion posicion) {
        super(posicion);
        this.energia = 2;
        this.velocidad = 2;
        this.danio = 2;
    }
  
    private int darRecompensa(){
        int recompensa = (int)(Math.random()*10+1);
        return recompensa;
    }

    public void morir(Jugador jugador, Contador muertesDeArañas){
        jugador.sumarCreditos(darRecompensa());
    }
  
    public void avanzar(Posicion siguientePosicion){
    	this.posicion = siguientePosicion;
    }
    
  public Posicion getPosicion() {
    	return this.posicion;
    }

    @Override
    public String toString() {
        return "arana";
    }

}
