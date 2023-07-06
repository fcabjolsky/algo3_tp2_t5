package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public abstract class DefensaView extends Region {

    private Image imagen;
    public DefensaView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y) {
        this.imagen = new Image(DefensaView.class.getResourceAsStream(urlTorreImagen));
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(altoTile);
        this.setWidth(anchoTile);
        BackgroundImage fondo = new BackgroundImage(this.imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(anchoTile, altoTile, false, false, true, true));
        this.setBackground(new Background(fondo));
    }
    public abstract void update(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY);
}
