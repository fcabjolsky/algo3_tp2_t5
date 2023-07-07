package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class TopoView extends EnemigoView{

    public TopoView(int anchoTile, int altoTile, int x, int y){
        super("/spriteTopo.png", anchoTile, altoTile, x, y);

    }
    @Override
    protected void loadSprites() {
        for (int j = 0; j < 7; j++){
            BufferedImage subimg = this.img.getSubimage(j*228,0, 228,228);
            Image nueva = convertirImagen(subimg);
            this.sprites.add(nueva);
        }
    }

    @Override
    protected Image imagenMovimientoAbajo() {
        return this.sprites.get(0);
    }

    @Override
    protected Image imagenMovimientoDerecha() {
        return this.sprites.get(0);
    }


}
