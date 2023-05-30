package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.AraniaMuerta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        arania.recibirDanio(2);

        assert(arania.estaMuerta());
    }

    @Test
    public void recibirDanioEnAraniaMuertaLanzaExcepcion() {
        Arania arania = new Arania();

        arania.recibirDanio(2);

        assertThrows(AraniaMuerta.class, () -> arania.recibirDanio(2));
    }
}
