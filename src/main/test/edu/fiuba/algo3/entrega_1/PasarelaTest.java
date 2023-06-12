package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Posicion;

public class PasarelaTest {
	@Test
    public void noEsPosibleConstruirDefesasSobrePasarela() {
    	//Arrange
    	Posicion p = new Posicion(0,0);
		
    	Pasarela nuevoRocoso = new Pasarela(p);

    	Torre torrePrimera = new Torre(0);
    	
    	
    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(torrePrimera));
    }

	@Test
	public void unaPasarelaDevuelveFalsoSiNoTieneEnemigos() {

		Pasarela pasarela = new Pasarela(new Posicion(0,0));

		boolean resultado = pasarela.contieneEnemigos();

		assertFalse(resultado);
	}

	@Test
	public void unaPasarelaDevuelveFalsoSiTodosLosEnemigosQueContieneEstanMuertos() {

		Pasarela pasarela = new Pasarela(new Posicion(1,1));
		Enemigo hormigaMuerta = new Hormiga(new Posicion(1, 1));
		hormigaMuerta.recibirDanio(1);
		pasarela.agregarEnemigo(hormigaMuerta);

		boolean resultado = pasarela.contieneEnemigos();

		assertFalse(resultado);
	}
}
