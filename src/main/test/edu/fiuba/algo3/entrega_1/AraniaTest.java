package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    public void recibirDanioEnAraniaMuertaLanzaExcepcion() {
        Arania arania = new Arania();

        arania.recibirDanio(2);

        assertThrows(EnemigoMuerto.class, () -> arania.recibirDanio(2));
    }

    @Test
    public void araniaAvanzaUnaParcelaCorrectamente() {
        Pasarela pasarelaLargada = new Pasarela(new Posicion(0, 0));
        Pasarela pasarelaSiguiente = new Pasarela(new Posicion(1,0));
        Arania arania = new Arania();
        pasarelaLargada.recibirEnemigo(arania);

        arania.avanzar(pasarelaSiguiente);

        assertTrue(pasarelaSiguiente.contieneEnemigos());
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

        assertFalse(pasarela3.contieneEnemigos());
    }
}
