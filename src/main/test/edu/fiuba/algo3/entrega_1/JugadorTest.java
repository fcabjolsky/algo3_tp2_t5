
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.*;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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
    public void NoSePuedenConstruirDefensasSiElJugadorNoDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador();
        Defensa torreBlanca = Mockito.mock(Defensa.class);
        Posicion posicion = new Posicion(1,2);
        Mockito.when(torreBlanca.puedeConstruir(100)).thenReturn(false);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torreBlanca, posicion));

    }
    @Test
    public void AlDestruirUnEnemigoSeLeAsignaAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador();
        Posicion posicion= new Posicion(1, 2);
        Hormiga hormiga = new Hormiga(posicion);
        Arania arania = Mockito.mock(Arania.class);
        Contador muertesDeHormigas = new Contador();

        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        assertEquals(103, jugador.getCreditos());
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        assertEquals(110, jugador.getCreditos());
        hormiga.morir(jugador, muertesDeHormigas);
        assertEquals(112, jugador.getCreditos());

    }

}
