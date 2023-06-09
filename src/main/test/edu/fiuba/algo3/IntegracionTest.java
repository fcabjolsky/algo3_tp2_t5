package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegracionTest {
    @Test
    public void simularUnaPartidaCompletaPerdida() {
        //Inicializacions

        Logger logger = new Logger();

        Jugador jugador = new Jugador("Jugador1");
        Mapa mapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json").crearMapa();
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        jugador.agregarObservador(logger);
        mapa.agregarObservador(logger);
        turno.agregarObservador(logger);

        Partida partida = new Partida(turno);
        partida.agregarObservador(logger);


        //primer turno no construyo torres
        partida.avanzarTurno();
        //segundo turno construyo una torre
        // Aca se necesita instancear una defejnsa
        Torre torreBlanca = new TorreBlanca(new Posicion(0, 3));
        torreBlanca.agregarObservador(logger);
        jugador.construirDefensa(torreBlanca);
        partida.avanzarTurno();
        // avanzo otro turno hasta morir
        while (!jugador.estaMuerto()) {
            partida.avanzarTurno();
        }
    }

    @Test
    public void simularUnaPartidaCompletaGanada() {
        //Inicializacions
        Logger logger = new Logger();

        Jugador jugador = new Jugador("Jugador1");
        Mapa mapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json").crearMapa();
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        jugador.agregarObservador(logger);
        mapa.agregarObservador(logger);
        turno.agregarObservador(logger);

        Partida partida = new Partida(turno);
        partida.agregarObservador(logger);

        //primer turno no construyo torres
        partida.avanzarTurno();
        //segundo turno construyo una torre
        // Aca se necesita instancear una defejnsa
        Torre torreBlana = new TorreBlanca(new Posicion(0, 3));
        torreBlana.agregarObservador(logger);
        jugador.construirDefensa(torreBlana);
        partida.avanzarTurno();
        // construyo otra torer
        Torre torrePlateada = new TorrePlateada(new Posicion(2, 3));
        torrePlateada.agregarObservador(logger);
        jugador.construirDefensa(torrePlateada);
        partida.avanzarTurno();
        // construyo otra torer
        Torre torreBlana2 = new TorreBlanca(new Posicion(3, 1));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();
        // construyo otra torer
        torreBlana2 = new TorreBlanca(new Posicion(2, 0));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();
        torreBlana2 = new TorreBlanca(new Posicion(3, 0));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();
        torreBlana2 = new TorreBlanca(new Posicion(4, 0));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();
        torreBlana2 = new TorreBlanca(new Posicion(5, 0));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();
        torreBlana2 = new TorreBlanca(new Posicion(7, 0));
        torreBlana2.agregarObservador(logger);
        jugador.construirDefensa(torreBlana2);
        partida.avanzarTurno();


        // avanzo otro turno hasta morir
        while (!partida.ganoPartida() && !jugador.estaMuerto()) {
            partida.avanzarTurno();
        }
        partida.avanzarTurno();
    }

    @Test
    public void simularUnaPartidaGanadaEnLaQueElJugadorVaRecolectandoLasRecompensasCorrectamente() {
        //Inicializacions
        Logger logger = new Logger();

        Jugador jugador = new Jugador("Jugador1");
        Mapa mapa = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json").crearMapa();
        Turno turno = new Turno(jugador, mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        jugador.agregarObservador(logger);
        mapa.agregarObservador(logger);
        turno.agregarObservador(logger);

        Partida partida = new Partida(turno);
        partida.agregarObservador(logger);


        jugador.construirDefensa(new TorrePlateada(new Posicion(0,2)));
        jugador.construirDefensa(new TorrePlateada(new Posicion(0,3)));
        jugador.construirDefensa(new TorrePlateada(new Posicion(13,7)));
        jugador.construirDefensa(new TorrePlateada(new Posicion(13,8)));
        jugador.construirDefensa(new TorrePlateada(new Posicion(13,9)));

        assertThrows(NoDisponeDeSuficientesCreditos.class, () -> jugador.construirDefensa(new TorreBlanca(new Posicion(0,0))));

        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();
        partida.avanzarTurno();


        assertDoesNotThrow(() -> jugador.construirDefensa(new TorreBlanca(new Posicion(0,0))));
    }

}
