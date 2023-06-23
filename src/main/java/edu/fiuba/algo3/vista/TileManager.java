package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.Entidad;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

public class TileManager {

    private PanelDePartida panelDePartida;
    private ArrayList<edu.fiuba.algo3.vista.Entidad> paisajes;
    private String[][] mapa;
    private HashMap<String, Entidad> parcelas;
    private String informacionDeMapa;


    public TileManager(PanelDePartida panelDePartida, String urlInformacionDeMapa) {
        try{
            this.informacionDeMapa = new String(Files.readAllBytes(Paths.get(urlInformacionDeMapa)));
            this.panelDePartida = panelDePartida;
            this.paisajes = new ArrayList();
            this.mapa = new String[panelDePartida.maximoDeColumnas][panelDePartida.maximoDeFilas];
            this.inicializarDiccionario();
            this.cargarMapa();
            this.inicializarPaisaje();
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }

    }

    public void inicializarDiccionario(){
        this.parcelas = new HashMap<>();
        Posicion posicion = new Posicion(0,0);
        this.parcelas.put("Pasarela", new PasarelaView(posicion));
        this.parcelas.put("Rocoso", new RocosoView(posicion));
        this.parcelas.put("Tierra", new TierraView(posicion));
    }

    public void inicializarPaisaje(){
        int col = 0, fil = 0, x = 0, y = 0;
        while(panelDePartida.maximoDeColumnas > col && panelDePartida.maximoDeFilas > fil){
            String parcela = this.mapa[fil][col];
            paisajes.add(this.parcelas.get(parcela).devolverNuevaInstancia(new Posicion(x, y)));
            col++;
            x += panelDePartida.tamanioDelTileAncho;
            if (col == panelDePartida.maximoDeColumnas){
                col = 0;
                x = 0;
                fil ++;
                y += panelDePartida.tamanioDelTileAlto;
            }
        }
    }
    public void draw(Graphics2D grafico){
       for (Entidad paisaje : paisajes){
           paisaje.draw(grafico, this.panelDePartida);
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
