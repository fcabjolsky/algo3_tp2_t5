package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Hormiga;
import edu.fiuba.algo3.modelo.Rango;
import edu.fiuba.algo3.modelo.EnemigoMuerto;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class HormigaTest {
    @Test
    public void recibirDanioUnoMataLaHormiga() {
        Hormiga hormiga = new Hormiga(new Posicion(0, 0));;

        hormiga.recibirDanio(1);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioCeroNoMataLaHormiga() {
        Hormiga hormiga = new Hormiga(new Posicion(0, 0));;

        hormiga.recibirDanio(0);

        assertFalse(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioDosMataALaHormiga() {
        Hormiga hormiga = new Hormiga(new Posicion(0, 0));;

        hormiga.recibirDanio(2);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioEnHormigaMuertaLanzaExcepcion() {
        Hormiga hormiga = new Hormiga(new Posicion(0, 0));;

        hormiga.recibirDanio(2);

        assertThrows(EnemigoMuerto.class, () -> hormiga.recibirDanio(2));
    }
    @Test
    public void hormigaEnRangoDevuelveTrue() {
        Posicion p = new Posicion(0, 0);

        Hormiga hormiga = new Hormiga(p);
        Rango r = Mockito.mock(Rango.class);
        when(r.estaEnRango(p)).thenReturn(true);

        assert(hormiga.estaEnRango(r));
    }
    @Test
    public void hormigaQueNoEstaEnRangoDevuelveFalse() {
        Posicion p = new Posicion(0, 0);

        Hormiga hormiga = new Hormiga(p);
        Rango r = Mockito.mock(Rango.class);
        when(r.estaEnRango(p)).thenReturn(false);

        assertFalse(hormiga.estaEnRango(r));
    }
    @Test
    public void hormigaAvanzaAlaParcelaCorrespondiente() {
    	 
    	Posicion p0 = new Posicion(0, 0);
    	Posicion p1 = new Posicion(1,0);
    	
    	Pasarela pasarelaLargada = new Pasarela(p0);
    	Pasarela pasarelaSiguiente = new Pasarela(p1);
    	
    	Hormiga hormiga = new Hormiga(p0);
    	
    	hormiga.avanzar(p1);
    	assertEquals(pasarelaSiguiente.getPosicion(), hormiga.getPosicion());	
    	
    }
    
}
