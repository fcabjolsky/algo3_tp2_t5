package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TierraView extends Entidad {

    public TierraView(int anchoTile, int altoTile, int x, int y) {
        super(anchoTile, altoTile, x, y);
        super.imagen = inicializarImagenesDeTierra();
        this.setFill(new ImagePattern(super.imagen));
    }

    private Image inicializarImagenesDeTierra(){
        if(this.getX() == 14 && this.getY() == 14){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoDownRight.png")));
        }
        else if(this.getX() == 0 && this.getY() == 14){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoDownLeft.png")));
        }
        else if(this.getX() == 0 && this.getY() == 0){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoUpLeft.png")));
        }
        else if(this.getX() > 0 && this.getY() == 0){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoUp.png")));
        }
        else if(this.getX() == 14 && this.getY() > 0){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoRight.png")));
        }
        else if(this.getX() == 0 && this.getY() > 0){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoLeft.png")));
        }
        else if(this.getX() > 0 && this.getY() == 14){
            return ( new Image(TierraView.class.getResourceAsStream("/tierraExtremoDown.png")));
        }
        return  ( new Image(TierraView.class.getResourceAsStream("/tierra.png")));
    }
    @Override
    public Entidad devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y) {

        return (new TierraView(anchoTile, altoTile, x, y));
    }

}
