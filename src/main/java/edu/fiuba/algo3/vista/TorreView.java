package edu.fiuba.algo3.vista;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TorreView extends DefensaView{

    private DisparoAnimacion ataque;
    public TorreView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y) {
        super(urlTorreImagen, anchoTile, altoTile, x, y);
        ataque = new DisparoAnimacion(this, anchoTile, altoTile);
    }

    @Override
    public void update(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY){
        ataque.realizarAtaque(contenedor, mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
    }
}
