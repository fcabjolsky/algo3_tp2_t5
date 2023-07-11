package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

public class FinalDePartida extends Region {

    public FinalDePartida(String mensajeFinal){
        this.setPrefHeight(400);
        this.setPrefWidth(400);
        this.setLayoutX((PartidaViewController.anchoDePantalla/2)-200);
        this.setLayoutY((PartidaViewController.altoDePantalla/2)-200);
        Image imagen = (new Image(FinalDePartida.class.getResourceAsStream("/fondoFinal.jpg")));
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), false, false, true, true));
        this.setBackground(new Background(fondo));

        agregarMensajeFinal(mensajeFinal);

    }
    public void agregarMensajeFinal(String mensajeFinal){
        Label label = new Label(mensajeFinal);
        label.setLayoutY(200);
        label.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), new Insets(0))));
        label.setVisible(true);
        label.setFont(new Font(40));
        label.setLayoutX((this.getWidth()-label.getWidth())/2);
        this.getChildren().add(label);
    }

}
