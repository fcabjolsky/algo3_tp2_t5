package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TrampaArenaView extends DefensaView{

    private TornadoArenaAnimacion ataque;

    public TrampaArenaView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y) {
        super(urlTorreImagen, anchoTile, altoTile, x, y);
        this.ataque = new TornadoArenaAnimacion(this, anchoTile, altoTile);
    }

    @Override
    public void update(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY){
        this.ataque.realizarAtaque(contenedor, mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
    }
}
