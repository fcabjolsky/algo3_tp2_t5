package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Pasarela {

	private List<Enemigo> enemigos;

	private Posicion posicion;

	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<>();
	}

	public boolean agregarDefensa(Defensa defensa){
		return false;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public boolean contieneEnemigos() {
		if (this.enemigos.isEmpty()) {
			return false;
		}
		else {
			for (Enemigo enemigo : this.enemigos) {
				if (!enemigo.estaMuerta()) {
					return true;
				}
			}
			return false;
		}
	}

	public void agregarEnemigo(Enemigo enemigo){
		this.enemigos.add(enemigo);
		enemigo.avanzar(this.posicion);
	}
}
