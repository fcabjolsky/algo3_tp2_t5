
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Contador;
import edu.fiuba.algo3.modelo.NoDisponeDeSuficientesCreditos;

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
    public void NoSePuedenConstruirDefensasSiElJugadorNoDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador();
        Defensa torreBlanca = Mockito.mock(Defensa.class);
        Posicion posicion = new Posicion(1,2);
        Mockito.when(torreBlanca.puedeConstruir(100)).thenReturn(false);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torreBlanca, posicion));

    }
    @Test
    public void AlDestruir3EnemigosHormigasSeLeAsignanAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador();
        Posicion posicion= new Posicion(1, 2);
        Hormiga hormiga = new Hormiga(posicion);
        Jugador jugadorEsperado = new Jugador(20, 103);
        Contador muertesDeHormigas = new Contador();

        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);

        assertEquals(jugadorEsperado, jugador);
    }
    @Test
    public void AlDestruir11EnemigosHormigasSeLeAsignanAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador();
        Posicion posicion= new Posicion(1, 2);
        Hormiga hormiga = new Hormiga(posicion);
        Jugador jugadorEsperado = new Jugador(20, 112);
        Contador muertesDeHormigas = new Contador();

        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);
        hormiga.morir(jugador, muertesDeHormigas);

        assertEquals(jugadorEsperado, jugador);
    }

    @Test
    public void AlDestruirUnEnemigoAraniaSeLeAsignanAlJugadorCreditos(){
        Jugador jugador = new Jugador();
        Posicion posicion= new Posicion(1, 2);
        Arania arania = new Arania(posicion);
        Jugador jugadorOriginal = new Jugador(20, 100);
        Contador muertesDeAranias = new Contador();

        arania.morir(jugador, muertesDeAranias);

        assertNotEquals(jugadorOriginal, jugador);
    }

}
