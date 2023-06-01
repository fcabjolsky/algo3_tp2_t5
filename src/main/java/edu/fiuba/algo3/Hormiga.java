package edu.fiuba.algo3;

public class Hormiga extends Enemigo {
    public Hormiga(Posicion posicion) {
        super(posicion);
        this.energia = 1;
        this.velocidad = 1;
    }
    
    //por la velocidad que tiene puede moverse cierta cantidad de posiciones
    //tiene que cambiar la posicion
    //alguien tiene que entender la velocidad entonces puede determinar a que pasarela se 
    //mueve
    //alguien me dice hacia donde tengo 
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
