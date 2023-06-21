package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class DefensaTest {

    @Test
    public void unaTorreBlancaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
       Torre defensa = new TorreBlanca(new Posicion(0,0));
       defensa.avanzarTurno();
       defensa.avanzarTurno();
       Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
       unaPasarela.recibirEnemigo(new Hormiga());

       if(unaPasarela.defensaEstaEnRango(defensa)) {
           defensa.defender(unaPasarela.obtenerEnemigoAAtacar());
       }

       assertFalse(unaPasarela.contieneEnemigos());
    }

    @Test
    public void intentarAtacarUnEnemigoFueraDeRangoConUnaTorreBlancaNoAtaca() {
        Torre defensa = new TorreBlanca(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(7 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        if(unaPasarela.defensaEstaEnRango(defensa)) {
            defensa.defender(unaPasarela.obtenerEnemigoAAtacar());
        }

        assert(unaPasarela.contieneEnemigos());
    }

    @Test
    public void unaTorrePlateadaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        if(unaPasarela.defensaEstaEnRango(defensa)) {
            defensa.defender(unaPasarela.obtenerEnemigoAAtacar());
        }

        assertFalse(unaPasarela.contieneEnemigos());
    }

    @Test
    public void  intentarAtacarUnEnemigoFueraDeRangoConUnaTorrePlateadaNoAtaca() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(7 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        if(unaPasarela.defensaEstaEnRango(defensa)) {
            defensa.defender(unaPasarela.obtenerEnemigoAAtacar());
        }

        assert(unaPasarela.contieneEnemigos());
    }

}


