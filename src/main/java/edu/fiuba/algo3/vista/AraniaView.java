package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class AraniaView extends EnemigoView{

    public AraniaView(int anchoTile, int altoTile, int x, int y){
        super("/spriteArania.png", anchoTile, altoTile, x, y);
    }

    @Override
    protected void loadSprites() {
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                BufferedImage subimg = this.img.getSubimage(i*48,j*48,48,48);
                Image nueva = convertirImagen(subimg);
                this.sprites.add(nueva);
            }
        }
    }

    @Override
    protected Image imagenMovimientoAbajo() {
        return this.sprites.get(0);
    }

    @Override
    protected Image imagenMovimientoDerecha() {
        return this.sprites.get(2);
    }
}
