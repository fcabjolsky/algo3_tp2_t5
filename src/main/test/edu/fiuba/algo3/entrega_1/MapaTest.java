package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {

    @Test
    public void testUnMapaDevuelveFalsoSiNoTieneMasEnemigos() {

        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertFalse(resultado);
    }
  
    @Test
    public void testUnMapaDevuelveFalsoSiTodosSusEnemigosEstanMuertos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga();
        hormigaMuerta.recibirDanio(1);
        pasarela.recibirEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertFalse(resultado);
    }

    @Test
    public void testUnMapaDevuelveVerdaderoSiTieneEnemigosVivos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormiga = new Hormiga();
        pasarela.recibirEnemigo(hormiga);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertTrue(resultado);
    }

    @Test
    public void unMapaDevuelveCorrectamenteLasParcelasQueTienenEnemeigos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        pasarela.recibirEnemigo(new Hormiga());
        Pasarela pasarela2 = new Pasarela(new Posicion(2,1));
        pasarela2.recibirEnemigo(new Arania());
        pasarelas.add(pasarela);
        pasarelas.add(pasarela2);
        pasarelas.add(new Pasarela(new Posicion(3,1)));
        Mapa mapa = new Mapa(pasarelas, null, null);

        List<Pasarela> pasarelasConEnemigos = mapa.obtenerPasarelasConEnemigos();

        for (Pasarela p : pasarelasConEnemigos) {
            assertTrue(p.contieneEnemigosVivos());
        }
    }

    @Test
    public void unMapaDevuelveCorrectamenteLasParcelasQueSonTransitablesPorEnemigos() { //en un futuro directamente seran parcelas, no importa cuales sean, hoy por hoy solo son pasarelas las transitables
        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,1)));
        Pasarela pasarelaQueContendraEnemigos = new Pasarela(new Posicion(0,0));
        Mapa mapa = new Mapa(pasarelas, null, null);
        Enemigo unEnemeigo = new Hormiga();

        List<Transitable> pasarelasTransitables = mapa.obtenerParcelasTransitables();
        for (Transitable t : pasarelasTransitables) {
            t.recibirEnemigo(unEnemeigo);
            t.moverEnemigosA(pasarelaQueContendraEnemigos);
        }

        assertTrue(pasarelaQueContendraEnemigos.contieneEnemigosVivos());
    }

    @Test public void seNotificaElAgregadoDeUnaHormiga() {
        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(0,0)));

        Observador loggerMock = Mockito.mock(Logger.class);
        Mapa mapa = new Mapa(pasarelas, null, null);
        mapa.agregarObservador(loggerMock);
        Enemigo hormiga = new Hormiga();
        mapa.agregarEnemigo(hormiga);
        Mockito.verify(loggerMock, Mockito.times(1)).actualizar(mapa, "Agregando enemigo: Hormiga");
    }

    @Test public void seNotificaElAgregadoDeUnaArania() {
        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(0,0)));

        Observador loggerMock = Mockito.mock(Logger.class);
        Mapa mapa = new Mapa(pasarelas, null, null);
        mapa.agregarObservador(loggerMock);
        Enemigo arania = new Arania();
        mapa.agregarEnemigo(arania);
        Mockito.verify(loggerMock, Mockito.times(1)).actualizar(mapa, "Agregando enemigo: Arania");
    }
}
