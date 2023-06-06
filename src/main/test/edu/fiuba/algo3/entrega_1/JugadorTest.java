
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.NoDisponeDeSuficientesCreditos;
import edu.fiuba.algo3.modelo.Pasarela;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void elJugadorEmpiezaConLaVidaYcreditosCorrectos() {
        Jugador jugador = new Jugador();
        int vidaEsperada = 20, creditosEsperados = 100;
        assertEquals(vidaEsperada, jugador.getVida());
        assertEquals(creditosEsperados, jugador.getCreditos());
    }

    @Test
    public void NoSePuedenConstruirDefensasSiElJugadorNoDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador();
        Defensa torreBlanca = Mockito.mock(Defensa.class);
        Posicion posicion = new Posicion(1,2);
        Mockito.when(torreBlanca.puedeConstruir(100)).thenReturn(false);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torreBlanca, posicion));

    }

    @Test
    public void luegoDeRecibir20DanioElJugadorEstaMuerto() {
        Jugador jugador = new Jugador();
        jugador.perderVida(20);
        assert(jugador.estaMuerto());
    }

    @Test
    public void jugadorRecienCreadoNoEstaMuerto() {
        Jugador jugador = new Jugador();
        assertFalse(jugador.estaMuerto());
    }
    
    @Test 
    public void jugadorMuereCuandoEnLaPasarelaLlegadaHayDanioSuficienteParaMatarlo() {
    	Jugador jugador = new Jugador();
    	Pasarela pasarelaLlegada = new Pasarela( new Posicion(0,0) );
    	
	    	Arania enemigo1 = new Arania(new Posicion(1,0));
	    	Arania enemigo2 = new Arania(new Posicion(2,0));
	    	Arania enemigo3 = new Arania(new Posicion(3,0));
	    	Arania enemigo4 = new Arania(new Posicion(4,0));
	    	Arania enemigo5 = new Arania(new Posicion(5,0));
	    	Arania enemigo6 = new Arania(new Posicion(6,0));
	    	Arania enemigo7 = new Arania(new Posicion(7,0));
	    	Arania enemigo8 = new Arania(new Posicion(8,0));
	    	Arania enemigo9 = new Arania(new Posicion(9,0));
	    	Arania enemigo10 = new Arania(new Posicion(10,0));
	    	pasarelaLlegada.agregarEnemigo(enemigo1);
	    	pasarelaLlegada.agregarEnemigo(enemigo2);
	    	pasarelaLlegada.agregarEnemigo(enemigo3);
	    	pasarelaLlegada.agregarEnemigo(enemigo4);
	    	pasarelaLlegada.agregarEnemigo(enemigo5);
	    	pasarelaLlegada.agregarEnemigo(enemigo6);
	    	pasarelaLlegada.agregarEnemigo(enemigo7);
	    	pasarelaLlegada.agregarEnemigo(enemigo8);
	    	pasarelaLlegada.agregarEnemigo(enemigo9);
	    	pasarelaLlegada.agregarEnemigo(enemigo10);
    	
    	
    	pasarelaLlegada.ataqueTotal(jugador);
   
    	
    	assert(jugador.estaMuerto());
    }
}
