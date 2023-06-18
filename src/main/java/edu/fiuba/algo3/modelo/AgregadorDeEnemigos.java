package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AgregadorDeEnemigos{

    private Mapa mapa;
    private List<Enemigo> enemigosExistentes;
    private int hormigasNuevas = 0;
    private int araniasNuevas = 0;

    private String informacionDeEnemigos;

    public AgregadorDeEnemigos(String URLinformacionDeEnemigos, Mapa mapa) {
        try {
            Posicion posicion = new Posicion(0,0);
            this.enemigosExistentes = new ArrayList<>();
            enemigosExistentes.add(new Arania(posicion));
            enemigosExistentes.add(new Hormiga(posicion));
            this.informacionDeEnemigos = new String(Files.readAllBytes(Paths.get(URLinformacionDeEnemigos)));
            this.mapa = mapa;
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }

    }

    /*public void obtenerInformacionDeNuevosEnemigos(int numeroDeTurno) {
        int index = numeroDeTurno - 1;
        try {
            JSONArray jsonArray = new JSONArray(this.informacionDeEnemigos);
            if ( index >= jsonArray.length() ) {
            	index = index - ((index/jsonArray.length()) * jsonArray.length());
            }
                JSONObject objeto = jsonArray.getJSONObject(index);
                this.hormigasNuevas = objeto.getJSONObject("enemigos").getInt("hormiga");
                this.araniasNuevas = objeto.getJSONObject("enemigos").getInt("arana");
                agregarEnemigosAMapa(this.mapa);
        } catch (JSONException e) {
            throw new ElFormatoDeJSONNoEsValido();
        }
    }*/

    public void obtenerInformacionDeNuevosEnemigos(int numeroDeTurno) {
        int index = numeroDeTurno - 1;
        try {
            JSONArray jsonArray = new JSONArray(this.informacionDeEnemigos);
            if ( index >= jsonArray.length() ) {
                index = index - ((index/jsonArray.length()) * jsonArray.length());
            }
            JSONObject enemigos = jsonArray.getJSONObject(index).getJSONObject("enemigos");
            agregarEnemigosAMapa(this.mapa, "hormiga", enemigos.getInt("hormiga"));
            agregarEnemigosAMapa(this.mapa, "arana", enemigos.getInt("arana"));
        } catch (JSONException e) {
            throw new ElFormatoDeJSONNoEsValido();
        }
    }

    /*public void agregarEnemigosAMapa(Mapa mapa){
        Posicion posicion = new Posicion(0,0);
        for (int i = 0;  i < this.hormigasNuevas ; i++){
            mapa.agregarEnemigo(new Hormiga(posicion));
        }
        for (int j = 0;  j < this.araniasNuevas ; j++) {
            mapa.agregarEnemigo(new Arania(posicion));
        }
    }*/
    public void agregarEnemigosAMapa(Mapa mapa, String especie, int cantidad){
        for (Enemigo enemigo : enemigosExistentes){
            enemigo.agregarEnemigoAMapa(especie, mapa, cantidad);
        }
    }
}
