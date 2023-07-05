package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TurnoTest {
    @Test
    public void pasaUnTurnoYLosEnemigosSeMueven() { //creo que deberia ir en ProcesoDeMovimientoTest
        /*Jugador jugador = new Jugador();
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(new Pasarela(new Posicion(0, 1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        Enemigo enemigo1 = new Hormiga(new Posicion(0, 0));
        mapa.agregarEnemigo(enemigo1);
        Turno turno = new Turno(jugador, mapa);
        turno.moverEnemigos();
        Posicion nuevaPoscion = enemigo1.obtenerPosicion();

        assertEquals(0, nuevaPoscion.calcularDistanciaA(new Posicion(0, 1)));*/
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        Pasarela pasarelaQueTendraEnemigos = new Pasarela(new Posicion(0,1));
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(pasarelaQueTendraEnemigos);
        pasarelas.add(new Pasarela(new Posicion(0, 2)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        mapa.agregarEnemigo(new Hormiga());
        Turno turno = new Turno(new Jugador(), mapa);

        turno.siguienteTurno();

        assertTrue(pasarelaQueTendraEnemigos.contieneEnemigosVivos());


    }

    @Test
    public void unJugadorQueEliminaTodosLosEnemigosDevuelveVerdadero() {
        Mapa mapa = new Mapa(new ArrayList<Pasarela>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador(), mapa);

        boolean resultado = turno.ganoLaPartida();

        Assertions.assertTrue(resultado);
    }

    @Test
    public void unJugadorQueMatoATodosLosEnemigosDevuelveVerdadero() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga();
        hormigaMuerta.recibirDanio(1);
        pasarela.recibirEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador(), mapa);

        boolean resultado = turno.ganoLaPartida();

        Assertions.assertTrue(resultado);
    }
  
    public void pasarTurnoYUnaTorreAtacaAUnEnemigo() { //creo que deberia en ProcesoDeDefensaTest
        /*Jugador jugador = new Jugador();
        Torre torre = new TorreBlanca();
        jugador.construir(torre, new Posicion(1,1));
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(new Pasarela(new Posicion(0, 1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        Enemigo enemigo1 = new Hormiga(new Posicion(0, 0));
        mapa.agregarEnemigo(enemigo1);
        Turno turno = new Turno(jugador, mapa);
        turno.construirDefensas();
        turno.defenderseDeEnemigos();
        assert(enemigo1.estaMuerta());
         */
        Jugador jugador = new Jugador();
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,1)));
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(new Pasarela(new Posicion(0, 1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Enemigo enemigo = new Hormiga();
        mapa.agregarEnemigo(enemigo);
        Turno turno = new Turno(jugador, mapa);

        turno.siguienteTurno();

        assertTrue(enemigo.estaMuerta());

    }

    /*@Test
    public void seConstruyeUnaTorrePlateadaPasaUnTurnoYNoEstaOperativa(){ //creo que deberia ir en ProcesoDeDefensaTest
        Jugador jugador = new Jugador();
        Torre torre = new TorrePlateada();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        turno.construirDefensas();

        assertThrows(DefensaNoOperativa.class, () -> turno.defenderseDeEnemigos());

    }

    @Test
    public void seConstruyeUnaTorrePlateadaPasanDosTurnosYEstaOperativa() { //creo que deberia ir en ProcesoDeDefensa
        Jugador jugador = new Jugador();
        Torre torre = new TorrePlateada();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        turno.construirDefensas();
        turno.construirDefensas();

        assertDoesNotThrow(() -> turno.defenderseDeEnemigos());

    }

    @Test
    public void seConstruyeUnaTorreBlancaYNoEstaOperativa() { // creoq ue deberia ir en ProcesoDeDefensaTest
        Jugador jugador = new Jugador();
        Torre torre = new TorreBlanca();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        assertThrows(DefensaNoOperativa.class, () -> turno.defenderseDeEnemigos());

    }

    @Test
    public void seConstruyeUnaTorreBlancaPasaUnTurnoYEstaOperativa(){ //creo que deberia ir en ProcesoDeDefensaTest
        Jugador jugador = new Jugador();
        Torre torre = new TorreBlanca();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        turno.construirDefensas();

        assertDoesNotThrow(() -> turno.defenderseDeEnemigos());

    }*/

}
