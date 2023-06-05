package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.DefensaNoOperativa;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.TorreBlanca;
import edu.fiuba.algo3.modelo.TorrePlateada;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2 {

    @Test
    public void test01UnaTorreBlancaSeConstruyeYNoEstaOperativa(){

        TorreBlanca torre = new TorreBlanca();
        Enemigo enemigo = Mockito.mock(Enemigo.class);

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));

    }

    @Test
    public void test02UnaTorreBlancaSeConstruyeYLuegoDePasarUnTurnoEstaOperativa(){
        TorreBlanca torre = new TorreBlanca();
        Enemigo enemigo = Mockito.mock(Enemigo.class);

        torre.avanzarTurno();

        assertDoesNotThrow(() -> torre.defender(enemigo));
    }

    @Test
    public void test03UnaTorrePlateadaSeConstruyeYNoEstaOperativa(){

        TorrePlateada torre = new TorrePlateada();
        Enemigo enemigo = Mockito.mock(Enemigo.class);

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));

    }

    @Test
    public void test04UnaTorrePlateadaSeConstruyeYLuegoDePasarUnTurnoNoEstaOperativa(){
        TorrePlateada torre = new TorrePlateada();
        Enemigo enemigo = Mockito.mock(Enemigo.class);

        torre.avanzarTurno();

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));
    }

    @Test
    public void test05UnaTorrePlateadaSeConstruyeYLuegoDePasarDosTurnosEstaOperativa(){
        TorrePlateada torre = new TorrePlateada();
        Enemigo enemigo = Mockito.mock(Enemigo.class);

        torre.avanzarTurno();
        torre.avanzarTurno();

        assertDoesNotThrow(() -> torre.defender(enemigo));
    }
}
