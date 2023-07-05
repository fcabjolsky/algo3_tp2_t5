package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TopoTest {

    @Test
    public void cuandoElTopoLlegaAlFinalAtacaConDosDeDanioSiElNumeroDeTurnoEsImpar(){
        Topo t = new Topo();
        assertEquals(5, t.atacar(3));
    }
    @Test
    public void cuandoElTopoLlegaAlFinalAtacaConCincoDeDanioSiElNumeroDeTurnoEsPar(){
        Topo t = new Topo();
        assertEquals(2, t.atacar(2));
    }
    @Test
    public void elTopoNoMuereSiRecibeCienDeDanio(){
        Topo t = new Topo();
        t.recibirDanio(100);
        assert(!t.estaMuerta());
    }
    @Test
    public void elTopoNoMuereSiRecibeDanioInfinito(){
        Topo t = new Topo();
        t.recibirDanio(47847328);
        assert(!t.estaMuerta());
    }
    @Test
    public void elTopoCambiaSuVelocidadDependiendoDeLosTurnosPasados(){
        Topo tp = new Topo();
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
        }
        assert(tlist.getLast().contieneEnemigosVivos());
    }
}
