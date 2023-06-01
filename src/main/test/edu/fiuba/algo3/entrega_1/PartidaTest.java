package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PartidaTest {

    @Mock

    Mapa mapa;

    List<Enemigo> enemigos;

    @InjectMocks
    Partida partida;

    @Test
    public void unJugadorGanaElJuegoLuegoDeVerificarQueSeEliminaronTodosLosEnemigosPosibles() {
        Partida partida = new Partida(mapa, enemigos);
        List<Enemigo> nuevosEnemigosSimulado = new ArrayList<>();
        Mockito.when(mapa.obtenerEnemigosSiguienteTurno()).thenReturn(nuevosEnemigosSimulado);
        Mockito.when(this.enemigos).thenReturn(nuevosEnemigosSimulado);

        Assertions.assertThrows(JuegoGanado.class, partida::siguienteTurno);
    }

}
