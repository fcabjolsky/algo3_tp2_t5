package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcesoDeMovimienoTest {

    @Test
    public void procesoDeMovimientoMueveAUnaHormigaALaParcelaCorrespondienteCorrectamente() {
        List<Transitable> parcelasTransitables = new ArrayList<>();
        Transitable parcelaLargada = new Pasarela(new Posicion(0,0));
        parcelaLargada.recibirEnemigo(new Hormiga());
        Transitable parcelaMeta = new Pasarela(new Posicion(0,1));
        parcelasTransitables.add(parcelaLargada);
        parcelasTransitables.add(parcelaMeta);
        ProcesoDeMovimiento procesoDeMovimiento = new ProcesoDeMovimiento();

        procesoDeMovimiento.procesarMovimiento(parcelasTransitables);

        assertFalse(parcelaLargada.contieneEnemigos());
        assertTrue(parcelaMeta.contieneEnemigos());
    }

    @Test
    public void procesoDeMovimientoMueveUnaAraniaALaParcelaCorrespondienteCorrectamente() {
        List<Transitable> parcelasTransitables = new ArrayList<>();
        Transitable parcelaLargada = new Pasarela(new Posicion(0,0));
        parcelaLargada.recibirEnemigo(new Arania());
        Transitable parcelaIntermedia = new Pasarela(new Posicion(0,2));
        Transitable parcelaMeta = new Pasarela(new Posicion(0,3));
        parcelasTransitables.add(parcelaLargada);
        parcelasTransitables.add(parcelaIntermedia);
        parcelasTransitables.add(parcelaMeta);
        ProcesoDeMovimiento procesoDeMovimiento = new ProcesoDeMovimiento();

        procesoDeMovimiento.procesarMovimiento(parcelasTransitables);

        assertFalse(parcelaLargada.contieneEnemigos());
        assertFalse(parcelaLargada.contieneEnemigos());
        assertTrue(parcelaMeta.contieneEnemigos());
    }

    @Test
    public void procesoDeMovmientoMueveUnaHormigaYUnaAraniaASusParcelasCorrespondientesCorrectamente() {
        List<Transitable> parcelasTransitables = new ArrayList<>();
        Transitable parcelaLargada = new Pasarela(new Posicion(0,0));
        parcelaLargada.recibirEnemigo(new Arania());
        parcelaLargada.recibirEnemigo(new Hormiga());
        Transitable parcelaMetaHormiga = new Pasarela(new Posicion(0,2));
        Transitable parcelaMetaArania = new Pasarela(new Posicion(0,3));
        parcelasTransitables.add(parcelaLargada);
        parcelasTransitables.add(parcelaMetaHormiga);
        parcelasTransitables.add(parcelaMetaArania);
        ProcesoDeMovimiento procesoDeMovimiento = new ProcesoDeMovimiento();

        procesoDeMovimiento.procesarMovimiento(parcelasTransitables);

        assertFalse(parcelaLargada.contieneEnemigos());
        assertTrue(parcelaMetaArania.contieneEnemigos());
        assertTrue(parcelaMetaArania.contieneEnemigos());
    }

}
