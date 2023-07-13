package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PasarelaView extends Entidad {

    public PasarelaView(int anchoTile, int altoTile, int x, int y) {
        super(anchoTile, altoTile, x, y);
        super.imagen = new Image(PasarelaView.class.getResourceAsStream("/pasarela3.png"));
        this.setFill(new ImagePattern(super.imagen));
    }

    @Override
    public Entidad devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y) {
        return (new PasarelaView(anchoTile, altoTile, x, y));
    }

}
