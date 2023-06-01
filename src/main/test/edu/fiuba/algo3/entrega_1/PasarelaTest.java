package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Torre;

public class PasarelaTest {
	@Test
    public void noEsPosibleConstruirDefesasSobrePasarela() {
    	//Arrange
    	
    	Pasarela nuevoRocoso = new Pasarela();
    	
    	Torre torrePrimera = new Torre(0);
    	
    	
    	//Act - Assert
    	
    	assertFalse(nuevoRocoso.agregarDefensa(torrePrimera));
    }
}
