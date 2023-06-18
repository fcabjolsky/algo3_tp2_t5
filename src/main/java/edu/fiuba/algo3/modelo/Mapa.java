package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private Enemigo enemigo1;
    private List<Pasarela> pasarelas;
    private List<Rocoso> rocosos;
    private List<Tierra> tierras;
    private String informacionDeMapa;


    public Mapa(List<Pasarela> pasarelas, List<Rocoso> rocosos, List<Tierra> tierras) {
        this.pasarelas = pasarelas;
        this.rocosos = rocosos;
        this.tierras = tierras;
    }

    public Mapa(String urlInformacionDeMapa) {
        try {
            this.informacionDeMapa = new String(Files.readAllBytes(Paths.get(urlInformacionDeMapa)));
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }
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

    public void agregarEnemigo(Enemigo enemigo1) {
        pasarelas.stream().findFirst().get().agregarEnemigo(enemigo1);
        //pasarelas.get(0).agregarEnemigo(enemigo1);
    }

    public void pasarTurno() {
        for (int i = 0; i < pasarelas.size()-1; i++){
            pasarelas.get(i).moverEnemigosA(pasarelas.get(i+1));
        }
    }

    public List<Enemigo> obtenerEnemigosEnRango(Rango unRango) {
        List<Enemigo> enemigos = new ArrayList<>();
        for (Pasarela pasarela:this.pasarelas) {
            if (pasarela.estaEnRango(unRango)) {
                enemigos.addAll(pasarela.obtenerEnemigos());
            }
        }
        return enemigos;
    }

    public boolean contieneEnemigos() {
        for(Pasarela pasarela : this.pasarelas) {
            if(pasarela.contieneEnemigos()) {
                return true;
            }
        }
        return false;
    }
}
