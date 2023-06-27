package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class PartidaTest2 {

    @Test
    public void seSimulaUnaPartidaConElMapaYLosEnemigosCorrespondientesEnLaQueElJugadorGana() { //supongo que la posicion de la primer pasarela es (10 , 8) hay que soluicionar el lector del mapa
        Jugador jugador = new Jugador();
        jugador.construirDefensa(new TorreBlanca(new Posicion(9,8)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(11,8)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(9,10)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(9,11)));
        Observador loggerMock = Mockito.mock(Logger.class);
        Partida partida = new Partida(jugador, loggerMock);

        partida.avanzarTurno();
        partida.avanzarTurno();

        Mockito.verify(loggerMock, Mockito.times(1)).actualizar(partida, "Ganaste");
    }

}
