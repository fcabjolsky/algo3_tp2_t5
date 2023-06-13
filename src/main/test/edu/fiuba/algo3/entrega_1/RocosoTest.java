package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class RocosoTest {
	
	@Test
    public void noEsPosibleConstruirDefesasSobreTerrenoRocoso() {
    	//Arrange
    	
    	Rocoso nuevoRocoso = new Rocoso();

		Torre unaTorreBlanca = new TorreBlanca(new Posicion(2, 5));

    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(unaTorreBlanca));
    }
}
