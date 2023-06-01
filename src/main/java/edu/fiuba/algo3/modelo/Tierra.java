package edu.fiuba.algo3.modelo;


public class Tierra {
	
	private Defensa defensa;
	
	
	
	
	private Boolean puedoConstruir(){
		
		if(this.defensa!=null) {
			return false;
		}
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
