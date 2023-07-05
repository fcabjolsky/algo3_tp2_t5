
package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void elJugadorEmpiezaConLaVidaYcreditosCorrectos() {
        Jugador jugador = new Jugador("Jugador1");
        int vidaEsperada = 20, creditosEsperados = 100;
        assertEquals(vidaEsperada, jugador.getVida());
        assertEquals(creditosEsperados, jugador.getCreditos());
    }

    @Test
    public void NoSePuedeConstruirUnaTorreBlancaSiNoSeDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador(20, 5, "Jugador1");
        Posicion posicion = new Posicion(1,2);
        TorreBlanca torreBlanca = new TorreBlanca(posicion);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construirDefensa(torreBlanca));

    }

    @Test
    public void SePuedeConstruirUnaTorreBlancaSiSeTienenSuficientesCreditosYEstosSeGastan(){
        Jugador jugador = new Jugador(20, 100, "Jugador1");
        Posicion posicion = new Posicion(1,2);
        Jugador jugadorEsperado = new Jugador(20, 90, "Jugador1");
        TorreBlanca torreBlanca = new TorreBlanca(posicion);

        jugador.construirDefensa(torreBlanca);

        assertEquals(jugadorEsperado, jugador);

    }


    @Test
    public void NoSePuedeConstruirUnaTorrePlateadaSiNoSeDisponeDeSuficientesCreditos(){
        Jugador jugador = new Jugador(20, 5, "Jugador1");
        Posicion posicion = new Posicion(1,2);
        TorrePlateada torrePlateada = new TorrePlateada(posicion);
        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construirDefensa(torrePlateada));

    }

    @Test
    public void SePuedeConstruirUnaTorrePlateadaSiSeTienenSuficientesCreditosYEstosSeGastan(){
        Jugador jugador = new Jugador(20, 100, "Jugador1");
        Posicion posicionBlanca = new Posicion(1,2);
        Posicion posicionPlateada = new Posicion(1,3);
        Jugador jugadorEsperado = new Jugador(20, 70, "Jugador1");
        TorrePlateada torrePlateada = new TorrePlateada(posicionPlateada);
        TorreBlanca torreBlanca = new TorreBlanca(posicionBlanca);

        jugador.construirDefensa(torrePlateada);
        jugador.construirDefensa(torreBlanca);

        assertEquals(jugadorEsperado, jugador);

    }

    @Test
    public void AlDestruir3EnemigosHormigasSeLeAsignanAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador("Jugador1");
        Hormiga hormiga = new Hormiga();
        Jugador jugadorEsperado = new Jugador(20, 103, "Jugador1");
        ContadorDeMuertesDeHormiga.obtenerContador().resetearContador();

        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);

        assertEquals(jugadorEsperado, jugador);
    }
    @Test
    public void AlDestruir11EnemigosHormigasSeLeAsignanAlJugadorLosCreditosCorrespondientes(){
        Jugador jugador = new Jugador("Jugador1");
        Hormiga hormiga = new Hormiga();
        Jugador jugadorEsperado = new Jugador(20, 112, "Jugador1");
        ContadorDeMuertesDeHormiga.obtenerContador().resetearContador();

        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);
        hormiga.morir(jugador);

        assertEquals(jugadorEsperado, jugador);
    }

    @Test
    public void AlDestruirUnEnemigoAraniaSeLeAsignanAlJugadorCreditos(){
        Jugador jugador = new Jugador("Jugador1");
        Arania arania = new Arania();
        Jugador jugadorOriginal = new Jugador(20, 100, "Jugador1");

        arania.morir(jugador);

        assertNotEquals(jugadorOriginal, jugador);
    }

    @Test
    public void luegoDeRecibir20DanioElJugadorEstaMuerto() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.perderVida(20);
        assert(jugador.estaMuerto());
    }

    @Test
    public void jugadorRecienCreadoNoEstaMuerto() {
        Jugador jugador = new Jugador("Jugador1");
        assertFalse(jugador.estaMuerto());
    }

    @Test
    public void jugadorIngresaUnNombreValidoCorrectamente() {
        assertDoesNotThrow(() -> new Jugador("pepito"));
    }

    @Test
    public void jugadorIngresaUnNombreInvalido() {
        assertThrows(NombreInvalido.class,() -> new Jugador("   "));
        assertThrows(NombreInvalido.class,() -> new Jugador("123"));
    }
}
