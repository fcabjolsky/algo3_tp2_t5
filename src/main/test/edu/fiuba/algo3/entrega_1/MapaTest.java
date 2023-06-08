package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MapaTest {

    @Test

    public void test01UnMapaDevuelveFalsoSiNoTieneMasEnemigos() {

        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertFalse(resultado);

    }

    @Test

    public void test02UnMapaDevuelveFalsoSiTodosSusEnemigosEstanMuertos() {
        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormigaMuerta = new Hormiga(new Posicion(1, 1));
        hormigaMuerta.recibirDanio(1);
        pasarela.agregarEnemigo(hormigaMuerta);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertFalse(resultado);
    }

    @Test

    public void test03UnMapaDevuelveVerdaderoSiTieneEnemigosVivos() {

        List<Pasarela> pasarelas = new ArrayList<>();
        Pasarela pasarela = new Pasarela(new Posicion(1,1));
        Enemigo hormiga = new Hormiga(new Posicion(1, 1));
        pasarela.agregarEnemigo(hormiga);
        pasarelas.add(pasarela);

        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertTrue(resultado);
    }


}
