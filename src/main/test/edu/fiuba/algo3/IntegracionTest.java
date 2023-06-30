package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class IntegracionTest {
    @Test
    public void simularUnaPartidaCompletaPerdida() {
        //Inicializacions
        Logger logger = new Logger();
        Jugador jugador = new Jugador();
        jugador.agregarObservador(logger);
        Partida partida = new Partida(jugador, logger);


        //primer turno no construyo torres
        partida.avanzarTurno();
        //segundo turno construyo una torre
        // Aca se necesita instancear una defejnsa
        Torre torreBlana = new TorreBlanca(new Posicion(0, 3));
        torreBlana.agregarObservador(logger);
        jugador.construirDefensa(torreBlana);
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
        Jugador jugador = new Jugador();
        jugador.agregarObservador(logger);
        Partida partida = new Partida(jugador, logger);


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


        // avanzo otro turno hasta morir
        while (!partida.ganoPartida()) {
            partida.avanzarTurno();
        }
    }
}
