package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javax.imageio.ImageIO;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class RocosoView extends Entidad {

    public RocosoView(int anchoTile, int altoTile, int x, int y) {
        super(anchoTile, altoTile, x , y);
        super.imagen = this.inicializarImagenesDeRocoso();
        this.setFill(new ImagePattern(super.imagen));
    }

    private Image inicializarImagenesDeRocoso(){
        if(this.getX() == 14 && this.getY() == 14){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoDownRight.png")));
        }
        else if(this.getX() == 0 && this.getY() == 14){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoDownLeft.png")));
        }
        else if(this.getX() == 0 && this.getY() == 0){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoUpLeft.png")));
        }
        else if(this.getX() == 14 && this.getY() == 0){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoUpRight.png")));
        }
        else if(this.getX() > 0 && this.getY() == 0){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoUp.png")));
        }
        else if(this.getX() == 14 && this.getY() > 0){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoRight.png")));
        }
        else if(this.getX() == 0 && this.getY() > 0){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoLeft.png")));
        }
        else if(this.getX() > 0 && this.getY() == 14){
            return ( new Image(RocosoView.class.getResourceAsStream("/rocosoExtremoDown.png")));
        }
        return  (new Image(RocosoView.class.getResourceAsStream("/rocoso.png")));
    }
    @Override
    public Entidad devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y) {

        return (new RocosoView(anchoTile, altoTile, x, y));
    }
}
