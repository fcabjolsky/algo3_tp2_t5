package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HormigaTest {
    @Test
    public void recibirDanioUnoMataLaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(1);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioCeroNoMataLaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(0);

        assertFalse(hormiga.estaMuerta());
    }

    @Test
    public void recibirDanioDosMataALaHormiga() {
        Hormiga hormiga = new Hormiga();

        hormiga.recibirDanio(2);

        assert(hormiga.estaMuerta());
    }

    @Test
    public void unaHormigaAtacaCorrectamenteCausandoUnoDeDanio() {
        Hormiga hormiga = new Hormiga();

        assertEquals(hormiga.atacar(), 1);
    }

    @Test
    public void laHormigaLuegoDeAtacarUnaVezQuedaEnEstadoEliminadoYPorEndeAlAtacarUnaSegundaVezDevuelveDanioCero(){
        Hormiga hormiga = new Hormiga();

        hormiga.atacar();

        assertEquals(hormiga.atacar(), 0);
    }


    @Test
    public void unaHormigaMuertaDevuelveCorrectamenteLaRecompensaCuandoSeMataronMenosDe10Hormigas() {
        Hormiga hormiga = new Hormiga();
        hormiga.nuevoEstado(new EstadoMuerto());
        ContadorDeMuertesDeHormiga.obtenerContador().resetearContador();

        int recompensaEsperada = hormiga.morir();

        assertEquals(recompensaEsperada ,1);
    }

    @Test
    public void unaHormigaMuertaDevuelveCorrectamenteLaRecompensaCuandoSeMataronMasDe10Hormigas() {
        Hormiga hormiga = new Hormiga();
        hormiga.nuevoEstado(new EstadoMuerto());
        ContadorDeMuertesDeHormiga.obtenerContador().resetearContador();

        for (int i = 0; i < 10; i++) {
            ContadorDeMuertesDeHormiga.obtenerContador().incrementar();
        }
        int recompensaEsperada = hormiga.morir();

        assertEquals(recompensaEsperada, 2);
    }

    @Test
    public void unaHormigaVivaDevuelveRecompensa0PuesSoloLasHormigasMuertasDevuelvenRecompensa() {
        Hormiga hormiga = new Hormiga();

        int recompensaEsperada = hormiga.morir();

        assertEquals(recompensaEsperada, 0);
    }

    @Test
    public void hormigaAvanzaAlaParcelaCorrespondiente() {
    	Pasarela pasarelaLargada = new Pasarela(new Posicion(0, 0));
    	Pasarela pasarelaSiguiente = new Pasarela(new Posicion(1,0));
    	Hormiga hormiga = new Hormiga();

        pasarelaLargada.recibirEnemigo(hormiga);
    	hormiga.avanzar(pasarelaSiguiente);

        assertTrue(pasarelaSiguiente.contieneEnemigosVivos());
    }

    @Test
    public void unaHormigaSeMueveUnaPasarelasPeroNoSeMueveAUnaSegundaPasarela() {
        Pasarela pasarelaLargada = new Pasarela(new Posicion(0,0));
        Pasarela pasarela1 = new Pasarela(new Posicion(1,0));
        Pasarela pasarela2 = new Pasarela(new Posicion(2,0));

        Hormiga hormiga = new Hormiga();
        pasarelaLargada.recibirEnemigo(hormiga);

        hormiga.avanzar(pasarela1);
        hormiga.avanzar(pasarela2);

        assertFalse(pasarela2.contieneEnemigosVivos());
    }

    @Test
    public void toStringDevuelveElIdentificadorDelEnemigo() {
        Hormiga hormiga = new Hormiga();
        assertEquals("Hormiga", hormiga.toString());
    }

}
