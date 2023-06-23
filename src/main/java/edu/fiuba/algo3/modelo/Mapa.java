package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapa {
    
    private List<Pasarela> pasarelas;
    private List<Rocoso> rocosos;
    private List<Tierra> tierras;


    public Mapa(List<Pasarela> pasarelas, List<Rocoso> rocosos, List<Tierra> tierras) {
        this.pasarelas = pasarelas;
        this.rocosos = rocosos;
        this.tierras = tierras;
    }
    
    public void agregarEnemigo(Enemigo enemigo) {
        pasarelas.stream().findFirst().get().recibirEnemigo(enemigo);
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

    public List<Rocoso> getRocoso() {
        return this.rocosos;
    }

    public List<Tierra> getTierra() {
        return this.tierras;
    }
    public List<Pasarela> getPasarelas() {
        return this.pasarelas;
    }

}
