package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AraniaTest {
    @Test
    public void recibirDanioDosMataLaArania() {
        Arania arania = new Arania();

        arania.recibirDanio(2);

        assert(arania.estaMuerta());
    }

    @Test
    public void recibirDanioUnoNoMataLaArania() {
        Arania arania = new Arania();

        arania.recibirDanio(1);

        assertFalse(arania.estaMuerta());
    }

    @Test
    public void recibirDanioCeroNoMataLaArania() {
        Arania arania = new Arania();

        arania.recibirDanio(0);

        assertFalse(arania.estaMuerta());
    }

    @Test
    public void unaAraniaAtacaCorrectamenteCausandoDosDeDanio() {
        Arania arania = new Arania();

        assertEquals(arania.atacar(), 2);
    }

    @Test
    public void laAraniaLuegoDeAtacarUnaVezQuedaEnEstadoEliminadoYPorEndeAlAtacarUnaSegundaVezDevuelveDanioCero(){
        Arania arania = new Arania();

        arania.atacar();

        assertEquals(arania.atacar(), 0);
    }


    @Test
    public void unaAraniaMuertaDevuelveCorrectamenteLaRecompensa() {
        Arania arania = new Arania();
        arania.nuevoEstado(new EstadoMuerto());

        int recompensaEsperada = arania.morir();

        assertTrue(recompensaEsperada >= 1 && recompensaEsperada <= 10);
    }

    @Test
    public void unaAraniaVivaDevuelveRecompensa0PuesSoloLasAraniasMuertasDevuelvenRecompensa() {
        Arania arania = new Arania();

        int recompensaEsperada = arania.morir();

        assertEquals(recompensaEsperada, 0);
    }

    @Test
    public void araniaAvanzaUnaParcelaCorrectamente() {
        Pasarela pasarelaLargada = new Pasarela(new Posicion(0, 0));
        Pasarela pasarelaSiguiente = new Pasarela(new Posicion(1,0));
        Arania arania = new Arania();
        pasarelaLargada.recibirEnemigo(arania);

        arania.avanzar(pasarelaSiguiente);

        assertTrue(pasarelaSiguiente.contieneEnemigosVivos());
    }

    @Test
    public void unaAraniaSeMueveDosPasarelasPeroNoSeMueveAUnaTercerPasarela() {
        Pasarela pasarelaLargada = new Pasarela(new Posicion(0,0));
        Pasarela pasarela1 = new Pasarela(new Posicion(1,0));
        Pasarela pasarela2 = new Pasarela(new Posicion(2,0));
        Pasarela pasarela3 = new Pasarela(new Posicion(3,0));

        Arania arania = new Arania();
        pasarelaLargada.recibirEnemigo(arania);

        arania.avanzar(pasarela1);
        arania.avanzar(pasarela2);
        arania.avanzar(pasarela3);

        assertFalse(pasarela3.contieneEnemigosVivos());
    }

    @Test
    public void toStringDevuelveElIdentificadorDelEnemigo() {
        Arania arania = new Arania();
        assertEquals("Arania", arania.toString());
    }

}
