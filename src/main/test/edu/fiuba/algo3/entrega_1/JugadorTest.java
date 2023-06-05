
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.NoDisponeDeSuficientesCreditos;

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
}