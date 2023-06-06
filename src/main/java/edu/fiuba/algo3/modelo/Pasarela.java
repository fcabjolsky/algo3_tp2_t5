package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo;
public class Pasarela {
	
	private Posicion posicion;
	private ArrayList<Enemigo> enemigos;
	
	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<Enemigo>(); 
		
	}
	
	public boolean agregarDefensa(Defensa defensa){
		return false;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void ataqueTotal(Jugador jugador) {
		for( Enemigo enemigo: this.enemigos) {
			enemigo.atacar(jugador);	
		}
	}
	
	public void agregarEnemigo(Enemigo enemigo) {
		this.enemigos.add(enemigo);
	}
}
