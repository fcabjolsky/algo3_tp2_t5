package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.skin.SliderSkin;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarraDeVida extends Region{

    final int vidaInicial = 20;
    float vidaActual = 20;
    Region barraTrasera;
    public BarraDeVida() {
        this.barraTrasera = new Region();
        this.setPrefHeight(12);
        this.setPrefWidth(60);
        Image imagen = (new Image(BarraDeVida.class.getResourceAsStream("/vidaBarraFondo2.png")));
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), false, false, true, true));
        this.barraTrasera.setBackground(new Background(fondo));
        this.barraTrasera.setPrefWidth(80);
        this.barraTrasera.setPrefHeight(20);
        this.barraTrasera.setLayoutX(-20);
        this.barraTrasera.setLayoutY(-4);
        this.setLayoutX(30);
        this.setLayoutY(10);
        this.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), new Insets(0))));
        this.getChildren().add(this.barraTrasera);
    }

    public void perderVida(float danio){
        this.vidaActual = this.vidaActual - danio;
        float porcentajePerdidaVida = danio / this.vidaInicial;
        double acortarBarra =  this.getPrefWidth() - (this.getPrefWidth() * porcentajePerdidaVida);
        if (this.vidaActual <= 0){
            this.setPrefWidth(0);
        }else{
            this.setPrefWidth(acortarBarra);
        }
    }
}
