package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AgregadorDeEnemigosTest {

    @Test
    public void noSePuedeObtenerInformacionDeLosEnemigosSiElArchivoNoExiste(){
        String urlInfomacionDeEnemigos = "enemigosInvalido.json";

        assertThrows(NoSeEncontroElArchivoJSON.class, () -> new AgregadorDeEnemigos(urlInfomacionDeEnemigos));
    }

    @Test
    public void noSePuedeObtenerInformacionDeLosEnemigosSiElFormatoNoEsValido(){
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigosInvalido.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos);
        Pasarela inicio = new Pasarela((new Posicion(0,1)), agregadorDeEnemigos);

        assertThrows(ElFormatoDeJSONNoEsValido.class, () -> agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(0));
    }

    @Test
    public void SeObtieneLaInformacionDeUnArchivoValidoHastaElTercerTurnoYLaCantidadDeEnemigosEsLaEsperada(){
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos);
        Pasarela inicio = new Pasarela((new Posicion(0,1)), agregadorDeEnemigos);
        int cantidadEsperada = 6;

        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(2);
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(3);

        assertTrue(inicio.laCantidadDeEnemigosEsIgualA(cantidadEsperada));
    }

    @Test
    public void SeObtieneLaInformacionDeUnArchivoValidoHastaElPrimerTurnoYLaCantidadDeEnemigosEsLaEsperada(){
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos);
        Pasarela inicio = new Pasarela((new Posicion(0,1)), agregadorDeEnemigos);
        int cantidadEsperada = 1;

        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);

        assertTrue(inicio.laCantidadDeEnemigosEsIgualA(cantidadEsperada));
    }


}
