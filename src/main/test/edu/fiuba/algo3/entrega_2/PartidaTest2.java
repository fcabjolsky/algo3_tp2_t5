package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;

public class PartidaTest2 {
   @Test
    public void esLaEntidadCorrespondienteDeCrearElMapaYdevuelveUnTurno(){
        Jugador j = new Jugador();
        Partida p = new Partida(j);

        Turno t = p.empezarPartida();

        assert(t.getClass() == Turno.class);
    }




}
