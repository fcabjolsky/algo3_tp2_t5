package edu.fiuba.algo3.modelo;

public class Tierra {
	
	private Defensa defensa;
	
	
	private Boolean puedoConstruir(){
		//checkear que el atributo este lleno ¿Como hago eso?
		return true;
	}
	
	public Boolean agregarDefensa(Defensa defensa){
		if(this.puedoConstruir()) {
			this.defensa = defensa;
			return true;
		}
		return false;
	}
}
