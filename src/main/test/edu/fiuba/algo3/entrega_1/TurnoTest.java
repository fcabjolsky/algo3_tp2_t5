package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TurnoTest {
    @Test
    public void pasaUnTurnoYLosEnemigosSeMueven() {
        Jugador jugador = new Jugador();
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(new Pasarela(new Posicion(0, 1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        Enemigo enemigo1 = new Hormiga(new Posicion(0, 0));
        mapa.agregarEnemigo(enemigo1);
        Turno turno = new Turno(jugador, mapa);
        turno.moverEnemigos();
        Posicion nuevaPoscion = enemigo1.obtenerPosicion();

        assertEquals(0, nuevaPoscion.calcularDistanciaA(new Posicion(0, 1)));
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
        Enemigo hormigaMuerta = new Hormiga(new Posicion(1, 1));
        hormigaMuerta.recibirDanio(1);
        pasarela.agregarEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador(), mapa);

        boolean resultado = turno.ganoLaPartida();

        Assertions.assertTrue(resultado);
    }
  
    public void pasarTurnoYUnaTorreAtacaAUnEnemigo() {
        Jugador jugador = new Jugador();
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

    }

    @Test
    public void seConstruyeUnaTorrePlateadaPasaUnTurnoYNoEstaOperativa(){
        Jugador jugador = new Jugador();
        Torre torre = new TorrePlateada();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        turno.construirDefensas();

        assertThrows(DefensaNoOperativa.class, () -> turno.defenderseDeEnemigos());

    }

    @Test
    public void seConstruyeUnaTorrePlateadaPasanDosTurnosYEstaOperativa(){
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
    public void seConstruyeUnaTorreBlancaYNoEstaOperativa(){
        Jugador jugador = new Jugador();
        Torre torre = new TorreBlanca();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        assertThrows(DefensaNoOperativa.class, () -> turno.defenderseDeEnemigos());

    }

    @Test
    public void seConstruyeUnaTorreBlancaPasaUnTurnoYEstaOperativa(){
        Jugador jugador = new Jugador();
        Torre torre = new TorreBlanca();
        jugador.construir(torre, new Posicion(1,1));
        Mapa mapa = new Mapa(new ArrayList<>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(jugador, mapa);

        turno.construirDefensas();

        assertDoesNotThrow(() -> turno.defenderseDeEnemigos());

    }

}
