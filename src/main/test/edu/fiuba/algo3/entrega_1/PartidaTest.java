package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        Jugador jugador = new Jugador("Jugador1");
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));
        Partida partida = new Partida(turno);

        String stringEsperado = "GANASTE";

        Assertions.assertEquals(stringEsperado, partida.juegoGanado());

    }

}
