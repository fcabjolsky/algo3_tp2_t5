package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Pasarela implements Transitable{
  	private List<Enemigo> enemigos;
  	private Posicion posicion;

	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<>();
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

	public boolean laCantidadDeEnemigosEsIgualA(int numeroDeEnemigos){
		return ((int)enemigos.size() == numeroDeEnemigos);
	}

    public boolean defensaEstaEnRango(Defensa defensa) {
		return defensa.estaEnRango(this.posicion);
    }

	public Enemigo obtenerEnemigoADaniar() {
		int i = 0;
		Enemigo enemigo = this.enemigos.get(i);
		while (enemigo.estaMuerta()) {
			i++;
			enemigo = this.enemigos.get(i);
		}
		return enemigo;
	}

	public void moverEnemigosA(Transitable siguienteParcela) {
		List<Enemigo> enemigosQuePuedenSeguirMoviendose = this.enemigos.stream().
				filter(enemigo -> enemigo.sePuedeMover()).
				collect(Collectors.toList());
		Iterator<Enemigo> iterador = enemigosQuePuedenSeguirMoviendose.iterator();
		while (iterador.hasNext()) {
			Enemigo e = iterador.next();
			e.avanzar(siguienteParcela);
			this.enemigos.remove(e);
		}
	}

	public void daniarJugador(Jugador j){
		for(Enemigo e : this.enemigos){
			j.perderVida(e.atacar());
		}
	}
}

