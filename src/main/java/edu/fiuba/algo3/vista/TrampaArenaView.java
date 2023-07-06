package edu.fiuba.algo3.vista;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TrampaArenaView extends DefensaView{

    private TornadoArenaAnimacion ataque;

    public TrampaArenaView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y, Pane contenedor, GridPane mapa) {
        super(urlTorreImagen, anchoTile, altoTile, x, y, mapa);
        this.ataque = new TornadoArenaAnimacion(this, anchoTile, altoTile);
        contenedor.getChildren().add(this.ataque);
    }

    @Override
    public void update(Entidad pasarelaAtacada){
        this.ataque.realizarAtaque(pasarelaAtacada);
    }

}
