package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.vista.Entidad;
import edu.fiuba.algo3.vista.Tile;
import javafx.geometry.Pos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TierraView extends Entidad {
    private edu.fiuba.algo3.vista.Tile tile;
    public TierraView(Posicion posicion) {
        try{
            this.tile = new Tile();
            this.posicion = posicion;
            this.tile.imagen = ImageIO.read(getClass().getResource("/tierra.png"));
            System.out.println("x:"+this.posicion.getCoordenadaX()+" y:"+this.posicion.getCoordenadaY());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D grafico, PanelDePartida panelDePartida){
        grafico.drawImage(tile.imagen, posicion.getCoordenadaX(), posicion.getCoordenadaY(),
                panelDePartida.tamanioDelTileAncho, panelDePartida.tamanioDelTileAlto, null);
    }
}
