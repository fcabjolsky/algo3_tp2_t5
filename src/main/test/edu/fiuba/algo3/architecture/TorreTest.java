package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.entrega_1.EnemigoMock;
import edu.fiuba.algo3.modelo.DefensaNoOperativa;
import edu.fiuba.algo3.modelo.Torre;
import edu.fiuba.algo3.modelo.TorreBlanca;
import edu.fiuba.algo3.modelo.TorrePlateada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TorreTest {

    @Test
    public void test01UnaTorreDeTiempoDeConstruccion0EstaOperativa(){

        Torre torre = new Torre(0);
        EnemigoMock enemigo = new EnemigoMock();

        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));

    }

    @Test
    public void test02UnaTorreDeTiempoDeConstruccion3SeConstruyeYLuegoDePasarDosTurnosNoEstaOperativa(){
        Torre torre = new Torre(3);
        EnemigoMock enemigo = new EnemigoMock();

        torre.avanzarTurno();
        torre.avanzarTurno();



        assertThrows(DefensaNoOperativa.class, () -> torre.defender(enemigo));
    }

    @Test
    public void test03UnaTorreDeTiempoDeConstruccion3SeConstruyeYLuegoDePasarTresTurnosEstaOperativa(){

        Torre torre = new Torre(3);
        EnemigoMock enemigo = new EnemigoMock();

        torre.avanzarTurno();
        torre.avanzarTurno();
        torre.avanzarTurno();

        assertDoesNotThrow(() -> torre.defender(enemigo));

    }
}
