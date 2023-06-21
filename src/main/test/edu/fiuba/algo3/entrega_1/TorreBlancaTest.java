package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TorreBlancaTest {

    @Test
    public void test01UnaTorreBlancaSeConstruyeYNoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga();

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));

    }

    @Test
    public void test02UnaTorreBlancaSeConstruyeYLuegoDePasarUnTurnoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);
        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga();

        torre.avanzarTurno();

        assertDoesNotThrow(() -> torre.defender(enemigo));
    }

}
