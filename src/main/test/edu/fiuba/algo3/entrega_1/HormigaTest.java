package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.HormigaMuerta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(2);

        assertThrows(HormigaMuerta.class, () -> hormiga.recibirDanio(2));
    }
}
