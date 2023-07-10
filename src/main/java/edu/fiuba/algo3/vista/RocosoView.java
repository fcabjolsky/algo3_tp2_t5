package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class RocosoView extends ParcelaView {

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
    public ParcelaView devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y) {

        return (new RocosoView(anchoTile, altoTile, x, y));
    }
}
