package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TorreBlancaTest {

    @Test
    public void test01UnaTorreBlancaSeConstruyeYNoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);
        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(enemigo);

        torre.defender(unaPasarela);

        assertFalse(enemigo.estaMuerta());
    }

    @Test
    public void test02UnaTorreBlancaSeConstruyeYLuegoDePasarUnTurnoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);
        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga();
        Pasarela unaPasarela = new Pasarela(new Posicion(2 ,1));
        unaPasarela.recibirEnemigo(enemigo);

        torre.avanzarTurno();
        torre.defender(unaPasarela);

        assertTrue(enemigo.estaMuerta());
    }

}
