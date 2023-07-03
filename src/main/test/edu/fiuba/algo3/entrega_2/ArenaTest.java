package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.TrampaArenosa;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class ArenaTest {
    @Test
    public void unEnemigoAtraviesaUnaTrampaArenosaYesRelantizadoSiSuVelocidadEsMayorQueUno(){
        TrampaArenosa ta = new TrampaArenosa(0, 25, 0);
        Arania a = new Arania();
        Arania atest = new Arania();
        //LinkedList<Enemigo> e = new LinkedList<Enemigo>();
        //e.add(a);

        ta.aplicarEfecto(a);

        assert(!atest.equalsVelocidad(a));
    }
    @Test
    public void unEnemigoAtraviesaUnaTrampaArenosaYesStuneadoSiSuVelocidadEsIgualQueUno(){
    }
    @Test
    public void laCreacionDeLaTrampaCuesta25Creditos(){}

    @Test
    public void laCreacionDeLaTrampaEsInmediataAlTurnoQueSeCrea(){}
    @Test
    public void laDuracionDeLaTrampaEsDe3Turnos(){}

    @Test
    public void laTrampaSoloEsCreableEnPasarelas(){}
    @Test
    public void laCreacionDeLaTrampaNoSePuedeDarEnLaUltimaNiPrimerPasarela(){

    }

}
