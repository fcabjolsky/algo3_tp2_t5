package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Pasarela implements Transitable, Turneable{
  	private List<Enemigo> enemigos;
  	private Posicion posicion;

	public Pasarela(Posicion posicion) {
		this.posicion = posicion;
		this.enemigos = new ArrayList<>();
	}

	public boolean agregarDefensa(Defensa defensa){
		return false;
	}

	public boolean contieneEnemigos() {
		return !this.enemigos.isEmpty();
	}

	public boolean contieneEnemigosVivos() {
		for (Enemigo enemigo : this.enemigos) {
			if (!enemigo.estaMuerta()) {
					return true;
			}
		}
		return false;
	}

	@Override
	public int recolectarRecompensas() {
		int recompensaTotal = 0;
		for (Enemigo enemigo : this.enemigos) {
			recompensaTotal += enemigo.morir();
		}
		return recompensaTotal;
	}

	public void recibirEnemigo(Enemigo enemigo){
		this.enemigos.add(enemigo);
		enemigo.notificarObservadores(enemigo.toString() + " se movio a " + this.posicion.toString());
		enemigo.notificarObservadores(this.posicion);
	}

	public boolean laCantidadDeEnemigosEsIgualA(int numeroDeEnemigos){
		return ((int)enemigos.size() == numeroDeEnemigos);
	}

    public boolean defensaEstaEnRango(Defensa defensa) {
		return defensa.estaEnRango(this.posicion);
    }

	public Enemigo obtenerEnemigoADaniar() {
		int i = 0;
		if(!this.enemigos.isEmpty()) {

		}
		Enemigo enemigo = this.enemigos.get(i);
		while (enemigo.estaMuerta()) {
			i++;
			enemigo = this.enemigos.get(i);
		}
		return enemigo;
	}


	public void moverEnemigosA(Transitable siguienteParcela) {
		if(siguienteParcela==null){
			Iterator<Enemigo> enemigosAeliminar = this.enemigos.iterator();
			while(enemigosAeliminar.hasNext()){
				Enemigo e = enemigosAeliminar.next();
				this.enemigos.remove(e);
			}
		}
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


	@Override
	public void avanzarTurno() {
		for (Enemigo enemigo : this.enemigos) {
			enemigo.avanzarTurno();
		}
	}

	public void daniarJugador(Jugador j) {
		for(Enemigo e : this.enemigos){
			j.perderVida(e.atacar());
		}
	}

	public void resetearTurnoEnemigos(){
		for(Enemigo enemigo : this.enemigos){
				enemigo.avanzarTurno();
		}
	}

	public void eliminarEnemigos(){
		this.enemigos.clear();
	}

	public Posicion getPosicion() {
		return posicion;
	}
}

