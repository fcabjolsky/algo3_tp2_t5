package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnoTest2 {

    @Test
    public void turnoArrojaCorrectamenteLaExcepcionJuegoGanadoAlVericarQueNoHayMasEnemigosEnElMapa() {
        Mapa mapa = new Mapa(new ArrayList<Pasarela>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador(), mapa);
        boolean resultado = false;

        try { turno.siguienteTurno();
        } catch (JuegoGanado juegoGanado) {
            resultado = true;
        }

        assertTrue(resultado);
    }

    @Test
    public void turnoArrojaCorrectamenteLaExcepcionJuegoGanadoAlVerificarQueTodosLosEnemigosEnElMapaEstanMuertos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga();
        hormigaMuerta.recibirDanio(1);
        pasarela.recibirEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);
        Mapa mapa = new Mapa(pasarelas, null, null);
        Turno turno = new Turno(new Jugador(), mapa);
        boolean resultado = false;

        try { turno.siguienteTurno();
        } catch (JuegoGanado juegoGanado) {
            resultado = true;
        }

        assertTrue(resultado);
    }

}
