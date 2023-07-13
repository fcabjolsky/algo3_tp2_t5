package edu.fiuba.algo3.vista;

import javafx.scene.image.ImageView;

public class Desaparicion implements Movimiento{
    ImageView image;
    public Desaparicion(ImageView imagen){
        this.image = imagen;
    }
    @Override
    public void correrMovimiento() {
        this.image.setVisible(false);
    }
}
