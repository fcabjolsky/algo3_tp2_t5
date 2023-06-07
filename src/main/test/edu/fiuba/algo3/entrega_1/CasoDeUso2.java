package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2 {

    @Test
    public void test01UnaTorreBlancaSeConstruyeYNoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga(posicion);
        Mapa mapa = Mockito.mock(Mapa.class);

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(mapa));

    }

    @Test
    public void test02UnaTorreBlancaSeConstruyeYLuegoDePasarUnTurnoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);
        TorreBlanca torre = new TorreBlanca(posicion);
        Enemigo enemigo = new Hormiga(posicion);

        torre.avanzarTurno();

        Mapa mapa = Mockito.mock(Mapa.class);
        assertDoesNotThrow(() -> torre.defender(mapa));
    }

    @Test
    public void test03UnaTorrePlateadaSeConstruyeYNoEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga(posicion);

        Mapa mapa = Mockito.mock(Mapa.class);
        assertThrows(DefensaNoOperativa.class, () -> torre.defender(mapa));

    }

    @Test
    public void test04UnaTorrePlateadaSeConstruyeYLuegoDePasarUnTurnoNoEstaOperativa(){

        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        torre.avanzarTurno();

        Enemigo enemigo = new Hormiga(posicion);
        Mapa mapa = Mockito.mock(Mapa.class);

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(mapa));
    }

    @Test
    public void test05UnaTorrePlateadaSeConstruyeYLuegoDePasarDosTurnosEstaOperativa(){
        Posicion posicion = new Posicion(0,0);

        TorrePlateada torre = new TorrePlateada(posicion);
        Enemigo enemigo = new Hormiga(posicion);

        torre.avanzarTurno();
        torre.avanzarTurno();

        Mapa mapa = Mockito.mock(Mapa.class);
        assertDoesNotThrow(() -> torre.defender(mapa));
    }
}
