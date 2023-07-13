package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class PartidaTest2 {

    @Test
    public void seSimulaUnaPartidaConElMapaYLosEnemigosCorrespondientesEnLaQueElJugadorGana() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,0)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(0,2)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(1,2)));
        jugador.construirDefensa(new TorreBlanca(new Posicion(3,0)));
        Observador loggerMock = Mockito.mock(Logger.class);
        CreadorMapaJson creadorMapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json");
        Mapa mapa = creadorMapa.crearMapa();
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));
        Partida partida = new Partida(jugador, mapa, turno);
        partida.agregarObservador(loggerMock);

        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();

        Mockito.verify(loggerMock, Mockito.atLeast(1)).actualizar(partida, "Ganaste");
    }

}
