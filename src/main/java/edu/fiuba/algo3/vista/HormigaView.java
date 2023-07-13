package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class HormigaView extends EnemigoView{

    public HormigaView( int x, int y){
        super("/spriteHormiga.png", x, y);
    }

    @Override
    protected void loadSprites(){
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                BufferedImage subimg = this.img.getSubimage(i*125,j*125,125,125);
                Image nueva = convertirImagen(subimg);
                this.sprites.add(nueva);
            }
        }
    }

    protected Image imagenMovimientoDerecha(){
        return this.sprites.get(2);
    }

    protected Image imagenMovimientoAbajo(){
        return this.sprites.get(0);
    }

}
