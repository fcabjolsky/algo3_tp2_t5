package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;

public class CreditosView extends Label implements Observador {
    private int creditos;

    public CreditosView(){
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

    @Override
    public void actualizar(Observable observable, Object argument) {
        if (argument instanceof Integer){
            int creditos = (int)argument;
            sumarCreditos(creditos);
            actualizarCreditos();
        }
    }
}
