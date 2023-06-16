package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PartidaTest {

    @Test
    public void seSimulaUnaPartidaEnLaQueElJugadorGanaLaPartidaen3Turnos {

        //Arrange
        List<Pasarela> pasarelas = new ArrayList<>();
        List<Tierra> tierras = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(0,0)));
        pasarelas.add(new Pasarela(new Posicion(0,1)));
        pasarelas.add(new Pasarela(new Posicion(0,2)));
        tierras.add(new Tierra());
        Mapa mapa = new Mapa(pasarelas, null,tierras);
        mapa.agregarEnemigo(new Hormiga());


    }
}
