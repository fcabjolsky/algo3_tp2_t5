package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TorreBlanca;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Torre;

public class PasarelaTest {
	@Test
    public void noEsPosibleConstruirDefesasSobrePasarela() {
    	//Arrange
      Posicion p = new Posicion(0,0);
		  Torre unaTorreBlanca = new TorreBlanca();
    	Pasarela nuevoRocoso = new Pasarela(p);
    	    	
    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(unaTorreBlanca));
    }
}
