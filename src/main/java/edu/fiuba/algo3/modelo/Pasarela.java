package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Collection;

import java.util.List;

public class Pasarela{
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

	public void moverEnemigosA(Pasarela otraPasarela){
		List<Enemigo> enMovimiento = new ArrayList<>();
		List<Enemigo> estaticos = new ArrayList<>();

		for (Enemigo enemigo : enemigos){
			if(enemigo.enMovimiento()){
				enMovimiento.add(enemigo);
			}else{
				estaticos.add(enemigo);
			}
		}

		for (Enemigo enemigo : enMovimiento){
			otraPasarela.agregarEnemigo(enemigo);
		}

		this.enemigos = estaticos;

		for (Enemigo enemigo : enemigos){
			enemigo.resetearAvance();
		}

	}

	public boolean estaEnRango(Rango unRango) {
		return unRango.estaEnRango(this.posicion);
	}

	public List<Enemigo> obtenerEnemigos() {
		return this.enemigos;
	}

	public boolean laCantidadDeEnemigosEsIgualA(int numeroDeEnemigos){
		return ((int)enemigos.size() == numeroDeEnemigos);
	}


}
