package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania(Posicion posicion) {
        super(posicion);
        this.energia = 2;
        this.velocidad = 2;
    }
    
    
    public void avanzar(Posicion siguientePosicion){
    	this.posicion = siguientePosicion;
    }
    public Posicion getPosicion() {
    	return this.posicion;
    }
    

}
