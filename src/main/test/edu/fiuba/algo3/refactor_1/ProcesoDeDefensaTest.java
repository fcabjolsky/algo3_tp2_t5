package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcesoDeDefensaTest {

    @Test
    public void procesoDeDefensaFiltraCorrectamenteLasParcelasEnRangoDeLaDefensa() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelaEnRango = proceso.obtenerPasarelasEnRango(defensa, pasarelas);

        for(Pasarela p : pasarelaEnRango) {
            assertTrue(p.contieneEnemigos());
        }
    }


    @Test
    public void procesoDeDefensaFiltraCorrectamenteLaParcelaADefender() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        Pasarela pasarelaADefender = proceso.obtenerPasarelaADefender(defensa, pasarelas);

        assertTrue(pasarelaADefender.contieneEnemigos());
    }
    /*
    @Test
    public void procesoDeDefensaProcesaCorrectamenteLasDefensaYDaniaLosEnemigosCorrectamente() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Defensa torre = new TorreBlanca(new Posicion(1,1));
        torre.avanzarTurno();
        List<Defensa> defensas = new ArrayList<>();
        defensas.add(torre);
        pasarelas.add(pasarela);
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();

        proceso.procesarDefensa(pasarelas, defensas);

        assertFalse(pasarela.contieneEnemigos());
    }*/
}
