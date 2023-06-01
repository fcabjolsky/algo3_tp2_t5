
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.Posicion;
import edu.fiuba.algo3.NoDisponeDeSuficientesCreditos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void elJugadorSoloConstruyeSiTieneSuficientesCreditos(){
        Jugador jugador = new Jugador();
        Defensa torreBlanca = Mockito.mock(Defensa.class);
        Posicion posicion = new Posicion(1,2);
        Mockito.when(torreBlanca.puedeConstruir(100)).thenReturn(false);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torreBlanca, posicion));

    }

    public void AlDestruirUnEnemigoSeLeAsignaAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador();
        Enemigo hormiga = Mockito.mock(Enemigo.class);
        Enemigo araña = Mockito.mock(Enemigo.class);


    }
}