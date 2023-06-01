package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Rocoso;
import edu.fiuba.algo3.modelo.Torre;

public class RocosoTest {
	
	@Test
    public void noEsPosibleConstruirDefesasSobreTerrenoRocoso() {
    	//Arrange
    	
    	Rocoso nuevoRocoso = new Rocoso();
    	
    	Torre torrePrimera = new Torre(0);
    	
    	
    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(torrePrimera));
    }
}
