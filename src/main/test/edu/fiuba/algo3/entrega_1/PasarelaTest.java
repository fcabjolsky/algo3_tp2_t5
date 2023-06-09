package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasarelaTest {

	@Test
	public void unaPasarelaRecibeEnemigosCorrectamente() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));

		pasarela.recibirEnemigo(new Hormiga());

		assertTrue(pasarela.contieneEnemigosVivos());

	}
	@Test
    public void noEsPosibleConstruirDefesasSobrePasarela() {
		Posicion p = new Posicion(0,0);
		Torre unaTorreBlanca = new TorreBlanca(new Posicion(0,0));
	  	Pasarela nuevoRocoso = new Pasarela(p);

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
		Enemigo hormigaMuerta = new Hormiga();
		hormigaMuerta.recibirDanio(1);
		pasarela.recibirEnemigo(hormigaMuerta);

		boolean resultado = pasarela.contieneEnemigosVivos();

		assertFalse(resultado);
	}

	@Test
	public void unaPasarelaDevuelveCorrectamenteElEnemigoADaniar() {
		Pasarela pasarela = new Pasarela(new Posicion(1,1));
		Enemigo hormigaMuerta = new Hormiga();
		hormigaMuerta.recibirDanio(1);
		pasarela.recibirEnemigo(hormigaMuerta);
		Enemigo araniaSobreviviente = new Arania();
		araniaSobreviviente.recibirDanio(1);
		pasarela.recibirEnemigo(araniaSobreviviente);

		Enemigo araniaSobrevivienteEsperada = pasarela.obtenerEnemigoADaniar();

		assertFalse(araniaSobrevivienteEsperada.estaMuerta());
	}

	@Test
	public void unaPasarelaDevuelveFalsoSiUnaDefensaNoEstaEnSuRango() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Defensa torre = new TorreBlanca(new Posicion(6,0));

		boolean resultado = pasarela.defensaEstaEnRango(torre);

		assertFalse(resultado);

	}

	@Test
	public void unaPasarelaDevuelveVerdaderoSiUnaDefensaNoEstaEnSuRango() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Defensa torre = new TorreBlanca(new Posicion(2,0));

		boolean resultado = pasarela.defensaEstaEnRango(torre);

		assertTrue(resultado);

	}

	@Test
	public void unaPasarelaRecolectaCorrectamenteLosCreditosDeLosEnemigosMuertosQueContiene() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Enemigo enemigoMuerto = new Hormiga();
		Enemigo enemigoEliminado = new Arania();
		enemigoMuerto.nuevoEstado(new EstadoMuerto());
		enemigoEliminado.nuevoEstado(new EstadoEliminado());
		pasarela.recibirEnemigo(enemigoMuerto);
		pasarela.recibirEnemigo(enemigoEliminado);
		pasarela.recibirEnemigo(new Topo());

		int recompensaEsperada = pasarela.recolectarRecompensas();

		assertEquals(recompensaEsperada, 1);

	}

	@Test
	public void unaPasarelaMueveLosEnemigosQueTieneAUnaParcela() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Pasarela siguientePasarela = new Pasarela(new Posicion(1,1));

		pasarela.recibirEnemigo(new Hormiga());
		pasarela.moverEnemigosA(siguientePasarela);

		assertTrue(siguientePasarela.contieneEnemigosVivos());
	}

	@Test
	public void unaPasarelaNoContieneMasEnemigosLuegoDeMoverlosALaSiguiente() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Pasarela siguientePasarela = new Pasarela(new Posicion(1,1));

		pasarela.recibirEnemigo(new Hormiga());
		pasarela.moverEnemigosA(siguientePasarela);

		assertFalse(pasarela.contieneEnemigosVivos());
	}

	@Test
	public void unaPasarelaSoloMueveLosEnemigosQuePuedenHacerloALaSiguientePasarela() {
		Pasarela pasarela = new Pasarela(new Posicion(0,0));
		Pasarela siguientePasarela = new Pasarela(new Posicion(1,1));
		Hormiga hormigaInmovil = new Hormiga();
		hormigaInmovil.avanzar(pasarela);

		pasarela.moverEnemigosA(siguientePasarela);

		assertTrue(pasarela.contieneEnemigosVivos());
	}

}
