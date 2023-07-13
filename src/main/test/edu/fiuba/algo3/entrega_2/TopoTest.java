package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.enemigo.Topo;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TopoTest {

    @Test
    public void cuandoElTopoLlegaAlFinalAtacaConDosDeDanioSiElNumeroDeTurnoEsImpar() {
        Topo t = new Topo();
        ContadorDeTurno.obtenerContador().resetearContador();
        ContadorDeTurno.obtenerContador().incrementar();

        assertEquals(5, t.atacar());
    }
    @Test
    public void cuandoElTopoLlegaAlFinalAtacaConCincoDeDanioSiElNumeroDeTurnoEsPar() {
        Topo t = new Topo();
        ContadorDeTurno.obtenerContador().resetearContador();
        ContadorDeTurno.obtenerContador().incrementar();
        ContadorDeTurno.obtenerContador().incrementar();

        assertEquals(2, t.atacar());
    }

    @Test
    public void elTopoLuegoDeAtacarUnaVezQuedaEnEstadoEliminadoYPorEndeAlAtacarUnaSegundaVezDevuelveDanioCero(){
        Topo t = new Topo();

        t.atacar();

        assertEquals(t.atacar(), 0);
    }

    @Test
    public void elTopoNoMuereSiRecibeCienDeDanio() {
        Topo t = new Topo();
        t.recibirDanio(100);
        assert(!t.estaMuerta());
    }
    @Test
    public void elTopoNoMuereSiRecibeDanioInfinito() {
        Topo t = new Topo();
        t.recibirDanio(47847328);
        assert(!t.estaMuerta());
    }

    @Test
    public void elTopoNoDaUnaRecompensaPorqueNoPuedeMorir() {
        Topo topo = new Topo();
        int recompensaEsperada;

        topo.recibirDanio(47847328);
        recompensaEsperada = topo.darRecompensa();

        assertEquals(recompensaEsperada, 0);
    }
    @Test
    public void elTopoCambiaSuVelocidadDependiendoDeLosTurnosPasados(){
        Topo tp = new Topo();
        ContadorDeTurno.obtenerContador().resetearContador();
        int i = 0;
        LinkedList<Transitable> tlist = new LinkedList<Transitable>();
        ProcesoDeMovimiento pm = new ProcesoDeMovimiento();
        while(i < 18){
            tlist.add( new Pasarela( new Posicion(i,0)));
            i++;
        }
        tlist.getFirst().recibirEnemigo(tp);
        for(i=0;i<11;i++){
            pm.procesarMovimiento(tlist);
            tp.avanzarTurno();
            ContadorDeTurno.obtenerContador().incrementar();
        }
        assert(tlist.getLast().contieneEnemigosVivos());
    }
}
