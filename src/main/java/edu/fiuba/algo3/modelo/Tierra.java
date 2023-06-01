package edu.fiuba.algo3.modelo;


public class Tierra {
	
	private Defensa defensa;
	
	
	
	
	private Boolean puedoConstruir(){
		return this.defensa!=null;
	}
	
	public Boolean agregarDefensa(Defensa defensa){
		if(this.puedoConstruir()) {
			this.defensa = defensa;
			return true;
		}
		return false;
	}
}
