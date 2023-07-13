package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TierraTest {
	
	
	
    @Test 
    public void esPosibleConstruirDefensasSobreTierraVacia() {    	
    	//Arrange
    
    	Tierra nuevaTierra = new Tierra();
    	
    	Torre unaTorreBlanca = new TorreBlanca(new Posicion(2, 5));
    	
    	//Act - Assert
    	
    	assert(nuevaTierra.agregarDefensa(unaTorreBlanca));
    	
    }
    
    @Test
    public void noEsPosibleConstruirDefesasSobreUnaTierraQueYaPoseeUnaDefensa() {
    	//Arrange
    	
    	Tierra nuevaTierra = new Tierra();

		Torre unaTorreBlanca = new TorreBlanca(new Posicion(2, 5));

		Torre unaTorrePlateada = new TorrePlateada(new Posicion(2, 10));
    	 
    	
    	//Act
    	
    	nuevaTierra.agregarDefensa(unaTorreBlanca);
    	
    	
    	//Assert
    	
    	assertFalse(nuevaTierra.agregarDefensa(unaTorrePlateada));
    }

}
