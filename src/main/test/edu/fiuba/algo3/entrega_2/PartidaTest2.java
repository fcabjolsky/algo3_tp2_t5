package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class PartidaTest2 {

    @Test
    public void seSimulaUnaPartidaConElMapaYLosEnemigosCorrespondientesEnLaQueElJugadorGana() {
        Jugador jugador = new Jugador();
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,0)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(0,2)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,2)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(3,0)));
        Observador loggerMock = Mockito.mock(Logger.class);
        Partida partida = new Partida(jugador, loggerMock);

        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();

        Mockito.verify(loggerMock, Mockito.atLeast(1)).actualizar(partida, "Ganaste");
    }

   @Test
    public void esLaEntidadCorrespondienteDeCrearElMapaYdevuelveUnTurno(){
        Jugador j = new Jugador();
        Partida p = new Partida(j);

        Turno t = p.empezarPartida();

        assert(t.getClass() == Turno.class);
    }

}
