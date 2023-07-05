package edu.fiuba.algo3.refactor_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InmovilizadoTest {

    @Test
    public void unEnemigoInmovilizadoNoPuedeMoverseMas() {
        Movible estadoEnemigo = new Inmovilizado();

        estadoEnemigo.moverA(new Hormiga(), new Pasarela(new Posicion(0,0)));

        assertFalse(estadoEnemigo.puedoSeguirMoviendome());
    }

}
