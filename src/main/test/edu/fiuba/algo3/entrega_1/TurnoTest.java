package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TurnoTest {
    @Test
    public void pasaUnTurnoYLosEnemigosSeMueven() {
        ArrayList<Pasarela> pasarelas = new ArrayList<Pasarela>();
        Pasarela pasarelaQueTendraEnemigos = new Pasarela(new Posicion(0,1));
        pasarelas.add(new Pasarela(new Posicion(0, 0)));
        pasarelas.add(pasarelaQueTendraEnemigos);
        pasarelas.add(new Pasarela(new Posicion(0, 2)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        mapa.agregarEnemigo(new Hormiga());
        Turno turno = new Turno(new Jugador("Jugador1"), mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        turno.siguienteTurno();

        assertTrue(pasarelaQueTendraEnemigos.contieneEnemigosVivos());


    }

    @Test
    public void unJugadorQueEliminaTodosLosEnemigosDevuelveVerdadero() {
        Mapa mapa = new Mapa(new ArrayList<Pasarela>(), new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador("Jugador1"), mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        boolean resultado = turno.ganoLaPartida();

        Assertions.assertTrue(resultado);
    }

    @Test
    public void unJugadorQueMatoATodosLosEnemigosDevuelveVerdadero() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga();
        hormigaMuerta.nuevoEstado(new EstadoMuerto());
        pasarela.recibirEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());
        Turno turno = new Turno(new Jugador("Jugador1"), mapa, new AgregadorDeEnemigos("src/main/java/edu/fiuba/algo3/modelo/enemigosV2.json", mapa));

        boolean resultado = turno.ganoLaPartida();

        Assertions.assertTrue(resultado);
    }

}
