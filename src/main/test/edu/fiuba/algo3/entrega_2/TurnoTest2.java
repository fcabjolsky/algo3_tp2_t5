package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TurnoTest2 {

    @Test
    public void turnoArrojaCorrectamenteLaExcepcionJuegoGanadoAlVerificarQueTodosLosEnemigosEnElMapaEstanMuertosLuegoDeDosTurno() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,1)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(2,1)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,3)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(2,3)));
        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,2)));
        pasarelas.add(new Pasarela(new Posicion(2,2)));
        pasarelas.add(new Pasarela(new Posicion(3,2)));
        Mapa mapa = new Mapa(pasarelas, null, null);
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        turno.siguienteTurno();

        assertThrows(JuegoGanado.class, () -> {
            turno.siguienteTurno();
        });
    }

    @Test
    public void turnoNoArrojaUnaExcepcionJuegoGanadoPuesAunHayEnemigosEnElMapaEnElSegundoTurno() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,1)));
        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,2)));
        pasarelas.add(new Pasarela(new Posicion(2,2)));
        pasarelas.add(new Pasarela(new Posicion(3,2)));
        Mapa mapa = new Mapa(pasarelas, null, null);
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        turno.siguienteTurno();

        assertDoesNotThrow(() -> {
            turno.siguienteTurno();
        });
    }

}
