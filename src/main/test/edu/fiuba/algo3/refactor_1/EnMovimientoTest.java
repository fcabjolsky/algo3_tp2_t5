package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.enemigo.EnMovimiento;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.enemigo.Movible;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnMovimientoTest {

    @Test
    public void unEnemigoEnMovimientoNoPuedeSeguirMoviendoseLuegoDeAlcanzarSuCapacidadDeMovimiento() {
        Movible estadoEnemigo = new EnMovimiento(1);

        estadoEnemigo.moverA(new Hormiga(), new Pasarela(new Posicion(0,0)));

        assertFalse(estadoEnemigo.puedoSeguirMoviendome());
    }

    @Test
    public void unEnemeigoEnMovimientoPuedeSeguirMoviendoseLuegoDeRealizarUnMovimiento() {
        Movible estadoEnemigo = new EnMovimiento(2);

        estadoEnemigo.moverA(new Hormiga(), new Pasarela(new Posicion(0,0)));

        assertTrue(estadoEnemigo.puedoSeguirMoviendome());
    }

}
