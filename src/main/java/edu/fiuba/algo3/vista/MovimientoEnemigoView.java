package edu.fiuba.algo3.vista;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovimientoEnemigoView implements Movimiento{

    private TranslateTransition movimiento;
    private Image imagenMovimiento;

    public MovimientoEnemigoView(TranslateTransition movimiento, Image imagenMovimiento){
        this.movimiento = movimiento;
        this.imagenMovimiento = imagenMovimiento;
    }

    public void correrMovimiento(){
        ((ImageView)this.movimiento.getNode()).setImage(this.imagenMovimiento);
        this.movimiento.play();
    }

}
