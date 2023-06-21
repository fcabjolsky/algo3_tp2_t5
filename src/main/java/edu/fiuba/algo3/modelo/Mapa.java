package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        pasarelas.get(0).recibirEnemigo(enemigo1);
    }

    public boolean contieneEnemigos() {
        for(Pasarela pasarela : this.pasarelas) {
            if(pasarela.contieneEnemigos()) {
                return true;
            }
        }
        return false;
    }

    public List<Pasarela> obtenerPasarelasConEnemigos() {

        List<Pasarela> pasarelasConEnemigos = this.pasarelas.stream().
                filter(pasarela -> pasarela.contieneEnemigos()).
                collect(Collectors.toList());
        return pasarelasConEnemigos;
    }

    public List<Transitable> obtenerParcelasTransitables() {
        List<Transitable> parcelasTransitables = this.pasarelas.stream()
                .filter(parcela -> parcela instanceof Transitable)
                .map(parcela-> (Transitable) parcela)
                .collect(Collectors.toList());
        return parcelasTransitables;
    }
}
