package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.defensa.Rango;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RangoTest {


    @Test
    public void unRangoCalculaSatisfactoriamenteSiAlcanzaUnObjetivo() {

        Rango rango = new Rango(3, new Posicion(0,0));
        Posicion posicionObjetivo = new Posicion(2, 1);

        Assertions.assertTrue(rango.estaEnRango(posicionObjetivo));

    }

    @Test
    public void unRangoCalculaSatisfactoriamenteSiNoAlcanzaUnObjetivo() {

        Rango rango = new Rango(3, new Posicion(0,0));
        Posicion posicionObjetivo = new Posicion(4, 1);

        Assertions.assertFalse(rango.estaEnRango(posicionObjetivo));
    }

}
