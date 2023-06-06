package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;

public class Hormiga extends Enemigo {
    public Hormiga(Posicion posicion) {
        super(posicion);
        this.energia = 1;

        this.velocidad = 1;
    }
    public void avanzar(Posicion siguientePosicion) {
    	this.posicion = siguientePosicion;
    }
    
    public int getVelocidad() {
    	return this.velocidad;
    }
    
    public Posicion getPosicion() {
    	return this.posicion;
    }
}
