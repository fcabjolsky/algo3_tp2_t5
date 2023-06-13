package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Torre;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TorreBlanca;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Posicion;

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
