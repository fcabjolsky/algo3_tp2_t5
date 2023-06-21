package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import java.util.List;

public class Pasarela implements Observador, Transitable{
	private AgregadorDeEnemigos observable;
  	private List<Enemigo> enemigos;
  	private Posicion posicion;


	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<>();
	}

	public Pasarela(Posicion posicion, AgregadorDeEnemigos observable) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<>();
		this.observable = observable;
		observable.agregarObservador(this);
	}

	public boolean agregarDefensa(Defensa defensa){
		return false;
	}


	public boolean contieneEnemigos() { //tal vez se deberia llamar contieneEnemigosVivos
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

	public void recibirEnemigo(Enemigo enemigo){
		this.enemigos.add(enemigo);
	}

	public void actualizar(){
		observable.agregarEnemigosAObservador(this.enemigos, this.posicion);
	}

	public boolean laCantidadDeEnemigosEsIgualA(int numeroDeEnemigos){
		return ((int)enemigos.size() == numeroDeEnemigos);
	}

    public boolean defensaEstaEnRango(Defensa defensa) {
		return defensa.estaEnRango(this.posicion);
    }

	public Enemigo obtenerEnemigoAAtacar() {
		return this.enemigos.get(0);
	}

	public void moverEnemigosA(Transitable siguienteParcela) { //esto tal vez pueda hacerse de manera mas eficiente
		int i = 0;
		while (this.enemigos.iterator().hasNext()) {
			Enemigo e = this.enemigos.get(i);
			e.avanzar(siguienteParcela);
			this.enemigos.remove(e);
			i++;
		}


	}
}

