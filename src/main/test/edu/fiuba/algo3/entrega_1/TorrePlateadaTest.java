package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TorrePlateadaTest {

    @Test
    public void test01UnaTorrePlateadaSeConstruyeYNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga();
        torre.defender(enemigo);

        assertFalse(enemigo.estaMuerta());
    }

    @Test
    public void test02UnaTorrePlateadaSeConstruyeYLuegoDePasarUnTurnoNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();
        Enemigo enemigo = new Hormiga();
        torre.defender(enemigo);

        assertFalse(enemigo.estaMuerta());
    }

    @Test
    public void test03UnaTorrePlateadaSeConstruyeYLuegoDePasarDosTurnosEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();
        torre.avanzarTurno();
        Enemigo enemigo = new Hormiga();
        torre.defender(enemigo);

        assertTrue(enemigo.estaMuerta());
    }

}
