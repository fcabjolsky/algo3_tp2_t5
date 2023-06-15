package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Partida {

    private final Mapa mapa;

    private final Jugador jugador;

    private Turno turno;
  
    
    public Partida(Mapa mapa, Jugador jugador) {
    	this.mapa = mapa;
        this.jugador = jugador;
        this.turno = new Turno(jugador, mapa);
    }

    public String juegoGanado() {
        if (this.turno.ganoLaPartida()) {
            return "GANASTE";
        }
        return "SEGUIR JUGANDO";
    }
   

    

}
