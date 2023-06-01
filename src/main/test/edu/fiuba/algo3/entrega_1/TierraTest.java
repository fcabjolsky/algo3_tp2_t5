package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import java.util.List;

import edu.fiuba.algo3.modelo.Tierra;
import edu.fiuba.algo3.modelo.Torre;



public class TierraTest {
	
	
	
    @Test 
    public void esPosibleConstruirDefensasSobreTierraVacia() {    	
    	//Arrange
    
    	Tierra nuevaTierra = new Tierra();	
    	
    	Torre unaTorre = new Torre();
    	
    	//Act - Assert
    	
    	assert(nuevaTierra.agregarDefensa(unaTorre));
    	
    }
    
    @Test
    public void noEsPosibleConstruirDefesasSobreUnaTierraQueYaPoseeUnaDefensa() {
    	//Arrange
    	
    	Tierra nuevaTierra = new Tierra();
    	
    	Torre torrePrimera = new Torre();
    	
    	Torre torreSegunda = new Torre();
    	 
    	
    	//Act
    	
    	nuevaTierra.agregarDefensa(torrePrimera);
    	
    	
    	//Assert
    	
    	assertFalse(nuevaTierra.agregarDefensa(torreSegunda));
    }

}
