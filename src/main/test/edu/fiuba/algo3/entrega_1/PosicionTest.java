package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {
    @Test
    public void dosPosicionesIgualesTienenDistanciaCero() {
        Posicion p1 = new Posicion(0, 1);
        Posicion p2 = new Posicion(0, 1);

        assertEquals(0, p1.calcularDistanciaA(p2));
    }
}
