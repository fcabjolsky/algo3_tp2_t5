package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.vista.Entidad;
import edu.fiuba.algo3.vista.Tile;
import javafx.geometry.Pos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class RocosoView extends Entidad {

    private edu.fiuba.algo3.vista.Tile tile;

    public RocosoView(Posicion posicion) {
        try{
            this.tile = new Tile();
            this.posicion = posicion;
            this.tile.imagen = ImageIO.read(getClass().getResource("/rocoso.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void draw(Graphics2D grafico, PanelDePartida panelDePartida){
        grafico.drawImage(tile.imagen, posicion.getCoordenadaX(), posicion.getCoordenadaY(),
                panelDePartida.tamanioDelTileAncho, panelDePartida.tamanioDelTileAlto, null);
    }

    @Override
    public Entidad devolverNuevaInstancia(Posicion posicion) {
        return (new RocosoView(posicion));
    }
}
