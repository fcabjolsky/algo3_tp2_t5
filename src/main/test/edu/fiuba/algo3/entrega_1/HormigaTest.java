package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HormigaTest {
    @Test
    public void recibirDanioUnoMataLaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(1);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioCeroNoMataLaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(0);

        assertFalse(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioDosMataALaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(2);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioEnHormigaMuertaLanzaExcepcion() {
        Hormiga hormiga = new Hormiga();;

        hormiga.recibirDanio(2);

        assertThrows(EnemigoMuerto.class, () -> hormiga.recibirDanio(2));
    }

    @Test
    public void hormigaAvanzaAlaParcelaCorrespondiente() {

    	Pasarela pasarelaLargada = new Pasarela(new Posicion(0, 0));
    	Pasarela pasarelaSiguiente = new Pasarela(new Posicion(1,0));
    	Hormiga hormiga = new Hormiga();

        pasarelaLargada.recibirEnemigo(hormiga);
    	hormiga.avanzar(pasarelaSiguiente);

        assertTrue(pasarelaSiguiente.contieneEnemigos());
    }

    @Test
    public void unaHormigaSeMueveUnaPasarelasPeroNoSeMueveAUnaSegundaPasarela() {
        Pasarela pasarelaLargada = new Pasarela(new Posicion(0,0));
        Pasarela pasarela1 = new Pasarela(new Posicion(1,0));
        Pasarela pasarela2 = new Pasarela(new Posicion(2,0));

        Hormiga hormiga = new Hormiga();
        pasarelaLargada.recibirEnemigo(hormiga);

        hormiga.avanzar(pasarela1);
        hormiga.avanzar(pasarela2);

        assertFalse(pasarela2.contieneEnemigos());
    }
    
}
