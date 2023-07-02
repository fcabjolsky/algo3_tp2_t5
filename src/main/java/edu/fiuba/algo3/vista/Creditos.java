package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;

public class Creditos extends Label{
    private int creditos;

    public Creditos(){
        this.creditos = 100;
        URL imagenIcono = getClass().getResource("/iconoCreditos.png");
        ImageView icono = new ImageView(new Image(imagenIcono.toString(), 20,20, false, false));
        this.setLayoutX(620);
        this.setLayoutY(0);
        this.setWidth(80);
        this.setHeight(20);
        this.setBackground(Background.EMPTY);
        this.setGraphic(icono);
        this.actualizarCreditos();
        this.setFont( Font.font("consola", FontWeight.BOLD, 20));
        this.setTextFill(Color.WHITE);
    }

    public void sumarCreditos(int creditosGanados){
        this.creditos += creditosGanados;
        this.actualizarCreditos();
    }

    public void perderCreditos(int creditosGastados){
        this.creditos -= creditosGastados;
        this.actualizarCreditos();
    }

    private void actualizarCreditos(){
        this.setText(Integer.toString(this.creditos));
    }
}
