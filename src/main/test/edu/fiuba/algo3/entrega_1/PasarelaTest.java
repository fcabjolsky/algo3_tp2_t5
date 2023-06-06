package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TorreBlanca;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Torre;

public class PasarelaTest {
	@Test
    public void noEsPosibleConstruirDefesasSobrePasarela() {
    	//Arrange
    	
    	Pasarela nuevoRocoso = new Pasarela();

		Torre unaTorreBlanca = new TorreBlanca(new Posicion(2, 5));
    	
    	
    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(unaTorreBlanca));
    }
}
