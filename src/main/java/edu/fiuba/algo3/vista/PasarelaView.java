package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class PasarelaView extends ParcelaView {

    public PasarelaView(int anchoTile, int altoTile, int x, int y) {
        super(anchoTile, altoTile, x, y);
        super.imagen = new Image(PasarelaView.class.getResourceAsStream("/pasarela3.png"));
        this.setFill(new ImagePattern(super.imagen));
    }

    @Override
    public ParcelaView devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y) {
        return (new PasarelaView(anchoTile, altoTile, x, y));
    }

}
