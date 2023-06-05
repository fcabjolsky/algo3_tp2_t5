package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DefensaTest {


    @Test
    public void unaTorreBlancaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
       Torre defensa = new TorreBlanca(new Posicion(0,0));
       defensa.avanzarTurno();
       defensa.avanzarTurno();

       Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));

       Assertions.assertDoesNotThrow(() -> defensa.defender(enemigoEnRango));

    }

    @Test
    public void intentarAtacarUnEnemigoFueraDeRangoConUnaTorreBlancaLanzaUnaExcepcion() {
        Torre defensa = new TorreBlanca(new Posicion(0,0));
        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));

        Assertions.assertThrows(EnemigoFueraDeRango.class,() -> defensa.defender(enemigoFueraDeRango));

    }

    @Test
    public void unaTorrePlateadaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();
        defensa.avanzarTurno();

        Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));

        Assertions.assertDoesNotThrow(() -> defensa.defender(enemigoEnRango));

    }

    @Test
    public void  intentarAtacarUnEnemigoFueraDeRangoConUnaTorrePlateadaLanzaUnaExcepcion() {
        Torre defensa = new TorrePlateada(new Posicion(0,0));
        defensa.avanzarTurno();

        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));

        Assertions.assertThrows(EnemigoFueraDeRango.class,() -> defensa.defender(enemigoFueraDeRango));
    }

}


