
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;

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
    public void NoSePuedeConstruirUnaTorreBlancaSiNoSeDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador(20, 5);
        Posicion posicion = new Posicion(1,2);
        TorreBlanca torreBlanca = new TorreBlanca();
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torreBlanca, posicion));

    }

    @Test
    public void SePuedeConstruirUnaTorreBlancaSiSeTienenSuficientesCreditosYEstosSeGastan(){
        Jugador jugador = new Jugador(20, 100);
        Posicion posicion = new Posicion(1,2);
        Jugador jugadorEsperado = new Jugador(20, 90);
        TorreBlanca torreBlanca = new TorreBlanca();

        jugador.construir(torreBlanca, posicion);

        assertEquals(jugadorEsperado, jugador);

    }


    @Test
    public void NoSePuedeConstruirUnaTorrePlateadaSiNoSeDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador(20, 5);
        Posicion posicion = new Posicion(1,2);
        TorrePlateada torrePlateada = new TorrePlateada();
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construir(torrePlateada, posicion));

    }

    @Test
    public void SePuedeConstruirUnaTorrePlateadaSiSeTienenSuficientesCreditosYEstosSeGastan(){
        Jugador jugador = new Jugador(20, 100);
        Posicion posicionBlanca = new Posicion(1,2);
        Posicion posicionPlateada = new Posicion(1,3);
        Jugador jugadorEsperado = new Jugador(20, 70);
        TorrePlateada torrePlateada = new TorrePlateada();
        TorreBlanca torreBlanca = new TorreBlanca();

        jugador.construir(torrePlateada, posicionPlateada);
        jugador.construir(torreBlanca, posicionBlanca);

        assertEquals(jugadorEsperado, jugador);

    }

    @Test
    public void AlDestruir3EnemigosHormigasSeLeAsignanAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador();
        Posicion posicion= new Posicion(1, 2);
        Hormiga hormiga = new Hormiga();
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
        Hormiga hormiga = new Hormiga();
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
        Arania arania = new Arania();
        Jugador jugadorOriginal = new Jugador(20, 100);
        Contador muertesDeAranias = new Contador();

        arania.morir(jugador, muertesDeAranias);

        assertNotEquals(jugadorOriginal, jugador);
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
