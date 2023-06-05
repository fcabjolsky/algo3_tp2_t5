package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.EnemigoMuerto;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Rango;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class AraniaTest {
    @Test
    public void recibirDanioDosMataLaArania() {
        Arania arania = new Arania(new Posicion(0, 0));

        arania.recibirDanio(2);

        assert(arania.estaMuerta());
    }

    @Test
    public void recibirDanioUnoNoMataLaArania() {
        Arania arania = new Arania(new Posicion(0, 0));

        arania.recibirDanio(1);

        assertFalse(arania.estaMuerta());
    }

    @Test
    public void recibirDanioCeroNoMataLaArania() {
        Arania arania = new Arania(new Posicion(0, 0));

        arania.recibirDanio(0);

        assertFalse(arania.estaMuerta());
    }

    @Test
    public void recibirDanioEnAraniaMuertaLanzaExcepcion() {
        Arania arania = new Arania(new Posicion(0, 0));

        arania.recibirDanio(2);

        assertThrows(EnemigoMuerto.class, () -> arania.recibirDanio(2));
    }
    @Test
    public void araniaEnRangoDevuelveTrue() {
        Posicion p = new Posicion(0, 0);

        Arania arania = new Arania(p);
        Rango r = Mockito.mock(Rango.class);
        when(r.estaEnRango(p)).thenReturn(true);

        assert(arania.estaEnRango(r));
    }
    @Test
    public void araniaQueNoEstaEnRangoDevuelveFalse() {
        Posicion p = new Posicion(0, 0);

        Arania arania = new Arania(p);
        Rango r = Mockito.mock(Rango.class);
        when(r.estaEnRango(p)).thenReturn(false);

        assertFalse(arania.estaEnRango(r));
    }
}
