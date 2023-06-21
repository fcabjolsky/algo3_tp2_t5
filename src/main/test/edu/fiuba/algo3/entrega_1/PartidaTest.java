package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PartidaTest {

    @Test

    public void test01UnJugadorGanaLaPartidaSiNoHayMasEnemigosVivos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga();
        hormigaMuerta.recibirDanio(1);
        pasarela.recibirEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Partida partida = new Partida(mapa, new Jugador());

        String stringEsperado = "GANASTE";

        Assertions.assertEquals(stringEsperado, partida.juegoGanado());

    }

}
