package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TorrePlateadaTest {

    @Test
    public void test01UnaTorrePlateadaSeConstruyeYNoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga(posicion);

        Mapa mapa = Mockito.mock(Mapa.class);
        assertThrows(DefensaNoOperativa.class, () -> torre.defender(mapa));

    }

    @Test
    public void test02UnaTorrePlateadaSeConstruyeYLuegoDePasarUnTurnoNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();

        Enemigo enemigo = new Hormiga(posicion);
        Mapa mapa = Mockito.mock(Mapa.class);

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(mapa));
    }

    @Test
    public void test03UnaTorrePlateadaSeConstruyeYLuegoDePasarDosTurnosEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga(posicion);

        torre.avanzarTurno();
        torre.avanzarTurno();

        Mapa mapa = Mockito.mock(Mapa.class);
        assertDoesNotThrow(() -> torre.defender(mapa));
    }

}
