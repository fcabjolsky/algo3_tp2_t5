package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TierraView extends Entidad {

    private DefensaView torre;
    public TierraView(int anchoTile, int altoTile, int x, int y) {
        super(anchoTile, altoTile, x, y);
        super.imagen = inicializarImagenesDeTierra();
        this.setFill(new ImagePattern(super.imagen));
    }
    public void setTorre(DefensaView torre){
        this.torre = torre;
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
