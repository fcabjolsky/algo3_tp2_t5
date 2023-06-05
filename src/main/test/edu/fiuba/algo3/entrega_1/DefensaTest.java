package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DefensaTest {


    @Test
    public void unaTorreBlancaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
       Torre defensa = new Blanca(new Posicion(0,0));
       Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));

       Assertions.assertDoesNotThrow(() -> defensa.defender(enemigoEnRango));

    }

    @Test
    public void intentarAtacarUnEnemigoFueraDeRangoConUnaTorreBlancaLanzaUnaExcepcion() {
        Torre defensa = new Blanca(new Posicion(0,0));
        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));

        Assertions.assertThrows(EnemigoFueraDeRango.class,() -> defensa.defender(enemigoFueraDeRango));

    }

    @Test
    public void unaTorrePlateadaAtacaSatisfactoriamenteUnEnemigoQueEstaEnRango() {
        Torre defensa = new Plateada(new Posicion(0,0));
        Enemigo enemigoEnRango = new Hormiga(new Posicion(2 ,1));

        Assertions.assertDoesNotThrow(() -> defensa.defender(enemigoEnRango));

    }

    @Test
    public void  intentarAtacarUnEnemigoFueraDeRangoConUnaTorrePlateadaLanzaUnaExcepcion() {
        Torre defensa = new Plateada(new Posicion(0,0));
        Enemigo enemigoFueraDeRango = new Hormiga(new Posicion(10,1));

        Assertions.assertThrows(EnemigoFueraDeRango.class,() -> defensa.defender(enemigoFueraDeRango));
    }

}


