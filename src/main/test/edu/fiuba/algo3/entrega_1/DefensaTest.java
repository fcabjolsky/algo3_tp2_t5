package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
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

       unaPasarela.daniarEnemigo(defensa);

       assertFalse(unaPasarela.contieneEnemigosVivos());
    }

    @Test
    public void intentarAtacarUnEnemigoFueraDeRangoConUnaTorreBlancaNoAtaca() {
        Torre defensa = new TorreBlanca(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(7 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        unaPasarela.daniarEnemigo(defensa);

        assert(unaPasarela.contieneEnemigosVivos());
    }

    @Test
    public void unaTorrePlateadaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        unaPasarela.daniarEnemigo(defensa);

        assertFalse(unaPasarela.contieneEnemigosVivos());
    }

    @Test
    public void  intentarAtacarUnEnemigoFueraDeRangoConUnaTorrePlateadaNoAtaca() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();
        Pasarela unaPasarela = new Pasarela(new Posicion(7 ,1));
        unaPasarela.recibirEnemigo(new Hormiga());

        unaPasarela.daniarEnemigo(defensa);

        assert(unaPasarela.contieneEnemigosVivos());
    }

}


