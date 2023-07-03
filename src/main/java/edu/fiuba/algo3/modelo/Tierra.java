package edu.fiuba.algo3.modelo;

public class Tierra implements Turneable {
	
	private Defensa defensa;
	private Posicion posicion;
  
	public Tierra() {
	}
  
	public Tierra(Posicion posicion) {
		this.posicion = posicion;
	}

	private Boolean puedoConstruir(){
		return this.defensa==null;
	}
	
	public Boolean agregarDefensa(Defensa defensa){
		if(this.puedoConstruir()) {
			this.defensa = defensa;
			return true;
		}
		return false;
	}

	@Override
	public void avanzarTurno() {
		this.defensa.avanzarTurno();
	}

}
