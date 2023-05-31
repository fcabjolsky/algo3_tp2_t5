
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.NoDisponeDeSuficientesCreditos;
import edu.fiuba.algo3.Defensa;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

public class JugadorTest {

    public JugadorTest() {
    }

    @Test
    public void elJugadorEmpiezaConLaVidaYcreditosCorrectos() {
        Jugador jugador = new Jugador();
        int vidaEsperada = 20, creditosEsperados = 100;
        assertEquals(vidaEsperada, jugador.getVida());
        assertEquals(creditosEsperados, jugador.getCreditos());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void elJugadorSoloConstruyeSiTieneSuficientesCreditos() throws Exception {
        Jugador jugador = new Jugador();
        Defensa torreBlanca = mock(Defensa.class);
        when(torreBlanca.puedeConstruir(100)).thenReturn(false);
        thrown.expect(NoDisponeDeSuficientesCreditos.class);
        jugador.construir(torreBlanca);
    }
}
