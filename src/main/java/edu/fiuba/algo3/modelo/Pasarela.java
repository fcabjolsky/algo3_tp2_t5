package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;

public class Pasarela {
	
	private Posicion posicion;

	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public boolean agregarDefensa(Defensa defensa){
		return false;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
}
