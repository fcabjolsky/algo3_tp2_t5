package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcesoDeDefensaTest {

    @Test
    public void procesoDeDefensaDevuelveLasParcelasEnRangoQueTienenEnemigosVivosYEstasNoEstanVacias() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        unaPasarela.recibirEnemigo(new Hormiga());
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelasEnRangoConEnemigosVivos = proceso.obtenerPasarelasEnRangoConEnemigosVivos(defensa, pasarelas);

        assertFalse(pasarelasEnRangoConEnemigosVivos.isEmpty());
    }


    @Test
    public void procesoDeDefensaDevuelveLasParcelasEnRangoQueTienenEnemigosVivosPeroEstaSoloTieneEnemigosMuertosPorEndeEstaVacia() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela unaPasarela = new Pasarela(new Posicion(0,0));
        Enemigo enemigoMuerto = new Hormiga();
        enemigoMuerto.recibirDanio(1);
        unaPasarela.recibirEnemigo(enemigoMuerto);
        pasarelas.add(unaPasarela);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelasEnRangoConEnemigosVivos = proceso.obtenerPasarelasEnRangoConEnemigosVivos(defensa, pasarelas);

        assertTrue(pasarelasEnRangoConEnemigosVivos.isEmpty());
    }

    @Test
    public void procesoDeDefensaDevuelveLasParcelasEnRangoQueTienenEnemigosVivosPeroSoloDevuelveAquellasQueTienenEnemigosVivosCorrectamente() {
        ProcesoDeDefensa proceso = new ProcesoDeDefensa();
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarelaConEnemigoMuerto = new Pasarela(new Posicion(0,0));
        Pasarela pasarelaConEnemigoVivo = new Pasarela(new Posicion(0,1));
        Enemigo enemigoMuerto = new Hormiga();
        enemigoMuerto.recibirDanio(1);
        pasarelaConEnemigoMuerto.recibirEnemigo(enemigoMuerto);
        pasarelaConEnemigoVivo.recibirEnemigo(new Hormiga());
        pasarelas.add(pasarelaConEnemigoMuerto);
        pasarelas.add(pasarelaConEnemigoVivo);
        Defensa defensa = new TorreBlanca(new Posicion(1,0));

        List<Pasarela> pasarelasEnRangoConEnemigosVivos = proceso.obtenerPasarelasEnRangoConEnemigosVivos(defensa, pasarelas);
        for (Pasarela pasarela : pasarelasEnRangoConEnemigosVivos) {
            assertTrue(pasarela.contieneEnemigosVivos());
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

        assertTrue(pasarelaADefender.contieneEnemigosVivos());
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
        defensa.defender(pasarelaADefender);

        assertFalse(pasarelaADefender.contieneEnemigosVivos());
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

        assertTrue(unaPasarela.contieneEnemigosVivos());
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

        assertFalse(unaPasarela.contieneEnemigosVivos());
    }

}
