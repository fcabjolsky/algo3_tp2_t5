package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnoTest {
    @Test
    public void pasaUnTurnoYLosEnemigosSeMueven() {
        Jugador jugador = new Jugador();
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(new Pasarela(new Posicion(0, 1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        Posicion pInicial = mapa.obtenerPosicionPasarelaInicial();
        Enemigo enemigo1 = new Hormiga(pInicial);
        mapa.agregarEnemigo(enemigo1);
        Turno turno = new Turno(jugador, mapa);
        turno.moverEnemigos();
        Posicion nuevaPoscion = enemigo1.obtenerPosicion();

        assertEquals(0, nuevaPoscion.calcularDistanciaA(new Posicion(0, 1)));
    }
}
