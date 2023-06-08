package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;


public class DefensaTest {


    @Test
    public void unaTorreBlancaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
       Torre defensa = new TorreBlanca(new Posicion(0,0));
       defensa.avanzarTurno();
       defensa.avanzarTurno();

       Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));
       List<Enemigo> enemigos = new ArrayList<>();
       enemigos.add(enemigoEnRango);
       Mapa mapa = Mockito.mock(Mapa.class);
       when(mapa.obtenerEnemigosEnRango(defensa.rango())).thenReturn(enemigos);

       defensa.defender(mapa);
       assert(enemigoEnRango.estaMuerta());
    }

    @Test
    public void intentarAtacarUnEnemigoFueraDeRangoConUnaTorreBlancaNoAtaca() {
        Torre defensa = new TorreBlanca(new Posicion(0,0));
        defensa.avanzarTurno();
        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));
        List<Enemigo> enemigos = new ArrayList<>();
        Mapa mapa = Mockito.mock(Mapa.class);
        when(mapa.obtenerEnemigosEnRango(defensa.rango())).thenReturn(enemigos);

        defensa.defender(mapa);

        assertFalse(enemigoFueraDeRango.estaMuerta());
    }

    @Test
    public void unaTorrePlateadaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();

        Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));
        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(enemigoEnRango);
        Mapa mapa = Mockito.mock(Mapa.class);
        when(mapa.obtenerEnemigosEnRango(defensa.rango())).thenReturn(enemigos);

        defensa.defender(mapa);
        assert(enemigoEnRango.estaMuerta());

    }

    @Test
    public void  intentarAtacarUnEnemigoFueraDeRangoConUnaTorrePlateadaNoAtaca() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();

        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));
        List<Enemigo> enemigos = new ArrayList<>();
        Mapa mapa = Mockito.mock(Mapa.class);
        when(mapa.obtenerEnemigosEnRango(defensa.rango())).thenReturn(enemigos);

        defensa.defender(mapa);

        assertFalse(enemigoFueraDeRango.estaMuerta());
    }

}


