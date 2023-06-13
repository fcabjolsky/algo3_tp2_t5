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
    
    private String informacionDeMapa;
    //habria que pensar que implica esto
    public Partida(Jugador jugador,String urlInformacionDeMapa) {
        this.jugador = jugador;
        try {
            this.informacionDeMapa = new String(Files.readAllBytes(Paths.get(urlInformacionDeMapa)));
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }
        this.turno = new Turno(jugador, mapa);
    }

    public String juegoGanado() {
        if (this.turno.ganoLaPartida()) {
            return "GANASTE";
        }
        return "SEGUIR JUGANDO";
    }
   

    public void obtenerInformacionDelMapa(){
        try {
            JSONArray mapa = new JSONArray(this.informacionDeMapa);
            for (int i = 0; i < mapa.length(); i++) {
                JSONObject objeto = mapa.getJSONObject(i);
                for (int j = 1; j < 16; j++) {
                    String numeroDeFila = String.valueOf(j);
                    System.out.println("El Numero de fila es: " + numeroDeFila);
                    JSONArray fila = objeto.getJSONObject("Mapa").getJSONArray(numeroDeFila);
                    for (int k = 0; k < fila.length(); k++) {
                        String parcela = fila.getString(k);
                        System.out.println("La parcela es:" +parcela);
                    }
                }
            }
        } catch (JSONException e) {
            throw new ElFormatoDeJSONNoEsValido();
        }
    }

}
