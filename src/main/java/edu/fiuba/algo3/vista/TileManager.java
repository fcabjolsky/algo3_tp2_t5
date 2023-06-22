package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.vista.Entidad;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TileManager {

    private PanelDePartida panelDePartida;
    private ArrayList<edu.fiuba.algo3.vista.Entidad> paisajes;

    public TileManager(PanelDePartida panelDePartida) {
        this.panelDePartida = panelDePartida;
        this.paisajes = new ArrayList();
        this.inicializarPaisaje();
    }

    public void inicializarPaisaje(){
        int col = 0;
        int fil = 0;
        int x = 0;
        int y = 0;
        while(panelDePartida.maximoDeColumnas > col && panelDePartida.maximoDeFilas > fil){
            paisajes.add(new PasarelaView(new Posicion(x,y)));
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
}
