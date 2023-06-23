package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcesoDeDefensaTest {

    @Test
    public void procesoDeDefensaDevuelveLasParcelasEnRangoYEstasNoEstanVacias() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelasEnRango = proceso.obtenerPasarelasEnRango(defensa, pasarelas);

        assertFalse(pasarelasEnRango.isEmpty());
    }

    @Test
    public void procesoDeDefensaFiltraCorrectamenteLasParcelasEnRangoDeLaDefensa() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelasEnRango = proceso.obtenerPasarelasEnRango(defensa, pasarelas);

        for(Pasarela p : pasarelasEnRango) {
            assertTrue(p.contieneEnemigos());
        }
    }


    @Test
    public void procesoDeDefensaFiltraCorrectamenteLaParcelaADefender() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        Pasarela pasarelaADefender = proceso.obtenerPasarelaADefender(defensa, pasarelas);

        assertTrue(pasarelaADefender.contieneEnemigos());
    }

    @Test
    public void procesoDeDefensaFiltraUnaParcelaADefenderQueContieneUnEnemigoValidoParaRecibirDanio() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));
        defensa.avanzarTurno();

        Pasarela pasarelaADefender = proceso.obtenerPasarelaADefender(defensa, pasarelas);
        defensa.defender(pasarelaADefender.obtenerEnemigoADaniar());

        assertFalse(pasarelaADefender.contieneEnemigos());
    }

    @Test
    public void procesoDeDefensaDaniaLosEnemigosRecienCuandoLasDefensasEstanActivas() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        List<Defensa> defensas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));
        defensas.add(defensa);

        proceso.procesarDefensa(pasarelas, defensas);

        assertTrue(unaPasarela.contieneEnemigos());
    }

    @Test
    public void procesoDeDefensaProcesaCorrectamenteLasDefensaYDaniaLosEnemigosCorrectamente() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        List<Defensa> defensas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        defensas.add(defensa);

        proceso.procesarDefensa(pasarelas, defensas);

        assertFalse(unaPasarela.contieneEnemigos());
    }

}
