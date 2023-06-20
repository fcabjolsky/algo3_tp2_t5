package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AgregadorDeEnemigos;
import edu.fiuba.algo3.modelo.CreadorMapaJson;
import edu.fiuba.algo3.modelo.ElFormatoDeJSONNoEsValido;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.NoSeEncontroElArchivoJSON;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;

import org.junit.jupiter.api.Test;

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
    
    /*
    @Test 
    public void losElementosSonSituadosEnElMapaListosParaComenzarElJuego() {
    	String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();
        
       
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos);
        agregadorDeEnemigos.agregarObservador(mapa.getPasarelas().get(0));
        mapa.getPasarelas().get(0).setObservable(agregadorDeEnemigos);
        //"act inyecta los enemigos"
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);
     
        assertTrue(mapa.getPasarelas().get(0).contieneEnemigos());
    }
    
    
    @Test 
    public void elJugadorMuereLuegoDeLosTurnosCorrespondientes() {
    	
    	//la partida tiene que crear el jugador, llamar al creador de mapa y crear el
    	// turno
    	
    	String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        CreadorMapaJson creadorDeMapa = new CreadorMapaJson(urlInfomacionDelMapa);
        Mapa mapa = creadorDeMapa.crearMapa();
        
       
        String urlInfomacionDeEnemigos = "src/main/java/edu/fiuba/algo3/modelo/enemigos.json";
        AgregadorDeEnemigos agregadorDeEnemigos = new AgregadorDeEnemigos(urlInfomacionDeEnemigos);
        agregadorDeEnemigos.agregarObservador(mapa.getPasarelas().get(0));
        mapa.getPasarelas().get(0).setObservable(agregadorDeEnemigos);
        
        Jugador jugador = new Jugador(1,0);
        Turno t = new Turno(jugador, mapa);


        
        //while( el jugador tenga vida, meter bichos al mapa, mover enemigos )
        agregadorDeEnemigos.obtenerInformacionDeNuevosEnemigos(1);
     
        //assertTrue(mapa.getPasarelas().get(0).contieneEnemigos());
    }*/
  
    
}
