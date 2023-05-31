package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.List;

import edu.fiuba.algo3.modelo.Tierra;
import edu.fiuba.algo3.modelo.Torre;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TierraTest {
	
	
	
    @Test 
    public void esPosibleConstruirDefensasSobreTierraVacia() {    	
    	//Arrange
    	//crear la tierra
    	Tierra nuevaTierra = new Tierra();
    	//crear la torre - no importa que torre sea 
    	//podria crear un mock object que sea de clase defensa entonces no tengo que crear la clase esta
    	
    	Torre unaTorre = new Torre();
    	
    	//valor esperado
    	Boolean valor;
    	
    	//Act
    	//mandarle el mensaje agregarDefensa y almacenarlo en una variable el booleano
    	valor = nuevaTierra.agregarDefensa(unaTorre);
    	
    	//Assert
    	//verificar que la respuesta obtenida de la construccion es Verdadero
    	assertEquals(true, valor);
    	
    }
    
    @Test
    public void noEsPosibleConstruirDefesasSobreUnaTierraQueYaPoseeUnaDefensa() {
    	//Arrange
    	//crear la tierra
    	Tierra nuevaTierra = new Tierra();
    	//crear la torre
    	Torre torrePrimera = new Torre();
    	//crear otra torre
    	Torre torreSegunda = new Torre();
    	//valor esperado 
    	Boolean valor;
    	
    	//Act
    	//mandarle el mensaje agregarDefensa y almacenarlo en una variable el booleano
    	nuevaTierra.agregarDefensa(torrePrimera);
    	//querer agregar otra torre en la misma tierra, almacenar el valor booleano false
    	valor = nuevaTierra.agregarDefensa(torreSegunda);
    	
    	//Assert
    	//verificar que la respuesta obtenida de la construccion es false
    	assertEquals(false, valor);
    }

}
