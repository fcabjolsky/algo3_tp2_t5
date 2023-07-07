package edu.fiuba.algo3.vista;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TrampaArenaView extends DefensaView{

    private TornadoArenaAnimacion ataque;

    public TrampaArenaView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y, Pane contenedor, GridPane mapa) {
        super(urlTorreImagen, anchoTile, altoTile, x, y, mapa, contenedor);
    }

    @Override
    public void update(Entidad pasarelaAtacada){
        this.ataque = new TornadoArenaAnimacion(this, super.anchoTile, super.altoTile);
        this.ataque.realizarAtaque( pasarelaAtacada, super.contenedor);
    }

}
