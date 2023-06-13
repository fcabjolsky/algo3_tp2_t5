package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {
  
    @Test
    public void test01PasaUnTurnoYUnaHormigaSeMueveALaPosicionEsperada(){

        List<Pasarela> pasarelas = new ArrayList<>();

        Posicion inicial = new Posicion(0,0);
        Posicion fin = new Posicion(0,1);

        pasarelas.add(new Pasarela(inicial));
        pasarelas.add(new Pasarela(fin));
        pasarelas.add(new Pasarela(new Posicion(0,2)));

        Mapa mapa = new Mapa(pasarelas, new ArrayList<>(), new ArrayList<>());

        Enemigo hormi = new Hormiga(inicial);
        mapa.agregarEnemigo(hormi);


        mapa.pasarTurno();


        Posicion esperada = hormi.obtenerPosicion();
        assertEquals(0, fin.calcularDistanciaA(esperada));

    }

    @Test
    public void test02PasaUnTurnoYUnaAraniaSeMueveALaPosicionEsperada(){

        List<Pasarela> pasarelas = new ArrayList<>();

        Posicion inicial = new Posicion(0,0);
        Posicion fin = new Posicion(1,1);

        pasarelas.add(new Pasarela(inicial));
        pasarelas.add(new Pasarela(new Posicion(0,1)));
        pasarelas.add(new Pasarela(fin));

        Mapa mapa = new Mapa(pasarelas, new ArrayList<>(), new ArrayList<>());

        Enemigo arania = new Arania(inicial);

        mapa.agregarEnemigo(arania);


        mapa.pasarTurno();


        Posicion esperada = arania.obtenerPosicion();

        assertEquals(0, fin.calcularDistanciaA(esperada));


    }

    @Test
    public void test03PasanDosTurnosYUnaHormigaSeMueveALaPosicionEsperada(){

        List<Pasarela> pasarelas = new ArrayList<>();

        Posicion inicial = new Posicion(0,0);
        Posicion fin = new Posicion(1,1);

        pasarelas.add(new Pasarela(inicial));
        pasarelas.add(new Pasarela(new Posicion(0,1)));
        pasarelas.add(new Pasarela(fin));


        Mapa mapa = new Mapa(pasarelas, new ArrayList<>(), new ArrayList<>());

        Enemigo hormi = new Hormiga(inicial);
        mapa.agregarEnemigo(hormi);

        mapa.pasarTurno();
        mapa.pasarTurno();

        Posicion esperada = hormi.obtenerPosicion();
        assertEquals(0, fin.calcularDistanciaA(esperada));


    }

    @Test
    public void test04PasanDosTurnosYUnaAraniaSeMueveALaPosicionEsperada(){

        List<Pasarela> pasarelas = new ArrayList<>();

        Posicion inicial = new Posicion(0,0);
        Posicion fin = new Posicion(1,2);

        pasarelas.add(new Pasarela(inicial));
        pasarelas.add(new Pasarela(new Posicion(0,1)));
        pasarelas.add(new Pasarela(new Posicion(1,1)));
        pasarelas.add(new Pasarela(fin));


        Mapa mapa = new Mapa(pasarelas, new ArrayList<>(), new ArrayList<>());

        Enemigo arania = new Arania(inicial);
        mapa.agregarEnemigo(arania);

        mapa.pasarTurno();
        mapa.pasarTurno();

        Posicion esperada = arania.obtenerPosicion();
        assertEquals(0, fin.calcularDistanciaA(esperada));


    }
  
    @Test
    public void test05UnMapaDevuelveFalsoSiNoTieneMasEnemigos() {

        List<Pasarela> pasarelas = new ArrayList<>();
        pasarelas.add(new Pasarela(new Posicion(1,1)));
        Mapa mapa = new Mapa(pasarelas, new ArrayList<Rocoso>(), new ArrayList<Tierra>());

        boolean resultado = mapa.contieneEnemigos();

        Assertions.assertFalse(resultado);
    }
  
    @Test
    public void test06UnMapaDevuelveFalsoSiTodosSusEnemigosEstanMuertos() {
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
    public void test07UnMapaDevuelveVerdaderoSiTieneEnemigosVivos() {

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
