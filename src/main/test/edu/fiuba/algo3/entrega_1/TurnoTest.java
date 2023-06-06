package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnoTest {
    @Test
    public void pasaUnTurnoYLosEnemigosSeMueven() {
        Jugador jugador = new Jugador();
        Mapa mapa = new Mapa();
        mapa.agregarParcela(new Pasarela(new Posicion(0, 0)));
        mapa.agregarParcela(new Pasarela(new Posicion(0, 1)));

        Posicion pInicial = mapa.obtenerPoscionInicial();
        Enemigo enemigo1 = new Hormiga(pInicial);
        mapa.agregarEnemigo(enemigo1);
        Turno turno = new Turno(jugador, mapa);
        turno.moverEnemigos();
        Posicion nuevaPoscion = enemigo1.obtenerPosicion();

        assertEquals(0, nuevaPoscion.calcularDistanciaA(new Posicion(0, 1)));
    }
}
