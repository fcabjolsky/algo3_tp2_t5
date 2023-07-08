package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TorrePlateadaTest {

    @Test
    public void test01UnaTorrePlateadaSeConstruyeYNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(enemigo);

        torre.defender(unaPasarela);

        assertFalse(enemigo.estaMuerta());
    }

    @Test
    public void test02UnaTorrePlateadaSeConstruyeYLuegoDePasarUnTurnoNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();
        Enemigo enemigo = new Hormiga();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(enemigo);

        torre.defender(unaPasarela);

        assertFalse(enemigo.estaMuerta());
    }

    @Test
    public void test03UnaTorrePlateadaSeConstruyeYLuegoDePasarDosTurnosEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();
        torre.avanzarTurno();
        Enemigo enemigo = new Hormiga();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(enemigo);

        torre.defender(unaPasarela);

        assertTrue(enemigo.estaMuerta());
    }

}
