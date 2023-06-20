package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreadorMapaJsonTest {
    @Test
    public void noSePuedeObtenerLaInformacionDelMapaSiElArchivoNoExiste(){
        String urlInfomacionDelMapa = "mapa.json";

        assertThrows(NoSeEncontroElArchivoJSON.class, () -> new CreadorMapaJson(urlInfomacionDelMapa));
    }

    @Test
    public void noSePuedeObtenerLaInformacionDelMapaSiElFormatoNoEsValido(){
        String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapaInvalido.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
  
        assertThrows(ElFormatoDeJSONNoEsValido.class, () -> creadorDeMapa.crearMapa());
    }
    
    @Test 
    public void losElementosLeidosDelJsonSeCorrespondenConUnObjetoDelMapa() {
    	
    	String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();
        
        assertEquals(47, mapa.getRocoso().size());
        assertEquals(154, mapa.getTierra().size());
        assertEquals(24, mapa.getPasarelas().size());
    }
    

    @Test 
    public void losElementosSonSituadosEnElMapaListosParaComenzarElJuego() {
    	String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();
        
       
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos, mapa);

        //"act inyecta los enemigos"
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);
     
        assertTrue(mapa.getPasarelas().get(0).contieneEnemigos());
    }




    @Test
    public void elJugadorConUnoDeVidaMuereLuegoDeLosTurnosCorrespondientes() {

        //la partida tiene que crear el jugador, llamar al creador de mapa y crear el
        // turno

        String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();


        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos, mapa);


        Jugador jugador = new Jugador(1,0);
        System.out.println(jugador.getVida());
        Turno t = new Turno(jugador, mapa);
        int i = 0;


        //TODO: el jugador tiene que morir automaticamente cuando llegan los enemigos a la ultima pasarella
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);
        while(i < mapa.getPasarelas().size()){
            if(i==23 && mapa.getPasarelas().get(i).contieneEnemigos()) {
                jugador.perderVida(1);
            }
            t.moverEnemigos();
            i++;
        }

        assertTrue(t.getJugador() ==0 );
    }
    @Test
    public void elJugadorConVeinteDeVidaMuereLuegoDeLosTurnosCorrespondientesYlosEnemigsoSeSpawneanCadaTurno() {
        String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos, mapa);
        Jugador jugador = new Jugador();
        Turno t = new Turno(jugador, mapa);
        int i = 0;

        while(i < 12) {
            agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(i + 1);
            i++;
        }
        i=0;
        //TODO: el jugador tiene que morir automaticamente cuando llegan los enemigos a la ultima pasarella
        while(i < (mapa.getPasarelas().size())){
            if(i==23 && mapa.getPasarelas().get(i).contieneEnemigos()) {
                List<Enemigo> enemigos = mapa.getPasarelas().get(i).obtenerEnemigos();
                for(Enemigo e : enemigos){
                    System.out.println(e.getClass());
                    jugador.perderVida(e.atacar());
                }
            }
            t.moverEnemigos();
            i++;
        }

        assertTrue(t.getJugador() ==0 );
    }

  
    
}
