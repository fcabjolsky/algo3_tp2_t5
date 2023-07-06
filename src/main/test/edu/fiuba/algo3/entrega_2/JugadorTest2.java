package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest2 {
    @Test
    public void elJugadorOriginalMuereAutomaticamenteCuandoLeAplicanElDanioLetal(){
        Jugador j = new Jugador("Jugador1");
        Partida p = new Partida(j);
        Turno t = p.empezarPartida();
        int recorridoDePasarelas = 24;
        int i = 0;

        while(i<recorridoDePasarelas){
            t.siguienteTurno();
            i++;
        }
        assert (j.estaMuerto());
    }
    @Test
    public void elJugadorOriginalMuereEn24TurnosEnUnMapaDeHormigasYaranias(){
        Jugador j = new Jugador("Jugador1");
        Partida p = new Partida(j);
        Turno t = p.empezarPartida();
        int numeroTurno = 1;

        while(!j.estaMuerto()){
            t.siguienteTurno();
            numeroTurno++;
        }
        assertEquals(25, numeroTurno);
    }



}
