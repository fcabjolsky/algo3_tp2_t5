package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ParcelaManager {

    private String[][] mapa;
    private HashMap<String, Entidad> parcelas;
    private String informacionDeMapa;
    private int maximoDeColumnas;
    private int maximoDeFilas;

    public ParcelaManager(Container mapa, String urlInformacionDeMapa, int maximoDeColumnas, int maximoDeFilas) {
        try{
            this.informacionDeMapa = new String(Files.readAllBytes(Paths.get(urlInformacionDeMapa)));
            this.maximoDeColumnas = maximoDeColumnas;
            this.maximoDeFilas = maximoDeFilas;
            this.mapa = new String[maximoDeColumnas][maximoDeFilas];
            this.inicializarDiccionario();
            this.cargarMapa();
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }
    }

    public void inicializarDiccionario(){
        this.parcelas = new HashMap<>();
        Posicion posicion = new Posicion(0,0);
        this.parcelas.put("Pasarela", new PasarelaView(posicion, 0, 0));
        this.parcelas.put("Rocoso", new RocosoView(posicion, 0, 0));
        this.parcelas.put("Tierra", new TierraView(posicion, 0, 0));
    }

    public void inicializarPaisaje(JPanel mapa, int altoTile, int anchoTile){
        for (int x = 0; x < this.maximoDeFilas; x++) {
            for (int y = 0; y < this.maximoDeColumnas; y++) {
                String parcela = this.mapa[x][y];
                mapa.add(this.parcelas.get(parcela).devolverNuevaInstancia(new Posicion(x, y), anchoTile, altoTile));
            }
        }
    }

    public void cargarMapa(){
        JSONObject json = new JSONObject(this.informacionDeMapa);
        JSONObject mapa = json.getJSONObject("Mapa");
        for(String fila: mapa.keySet()){
            int numeroFila = Integer.parseInt(fila) - 1;
            JSONArray fil = mapa.getJSONArray(fila);
            for(int i  = 0; i < fil.length(); i++) {
                this.mapa[numeroFila][i] = fil.getString(i);
            }
        }
    }

}
