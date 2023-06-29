package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;

public class JugadorTest2 {
    @Test
    public void elJugadorMuereAutomaticamenteCuandoLeAplicanElDanioLetal(){
        Jugador j = new Jugador(1,0);
        Partida p = new Partida(j);
        Turno t = p.empezarPartida();
        t.insertarEnemigosNuevos();
        int i = 0;

        while(i<24){
            t.siguienteTurno2();
            i++;
        }
        assert (j.estaMuerto());
    }
    @Test
    public void elJugadorOriginalMuereAutomaticamenteCuandoLeAplicanElDanioLetal(){
        Jugador j = new Jugador();
        Partida p = new Partida(j);
        Turno t = p.empezarPartida();
        t.insertarEnemigosNuevos();
        int recorridoDePasarelas = 24;
        int i = 0;

        while(i<recorridoDePasarelas){
            t.siguienteTurno2();
            t.insertarEnemigosNuevos();
            i++;
        }
        assert (j.estaMuerto());
    }
    @Test
    public void elJugadorOriginalMuereEn23TurnosEnUnMapaDeHormigasYaranias(){
        Jugador j = new Jugador();
        Partida p = new Partida(j);
        Turno t = p.empezarPartida();
        t.insertarEnemigosNuevos();
        int recorridoDePasarelas = 24;
        int numeroTurno = 1;

        while(numeroTurno <=recorridoDePasarelas && !j.estaMuerto()){
            t.siguienteTurno2();
            t.insertarEnemigosNuevos();
            numeroTurno++;
        }
        assert (numeroTurno == 24);
    }


}
