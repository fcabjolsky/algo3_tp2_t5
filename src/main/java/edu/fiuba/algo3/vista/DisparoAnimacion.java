package edu.fiuba.algo3.vista;

import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class DisparoAnimacion extends DefensaAtaquesView{

    ArrayList<Background> imagenesExplosion;

    public DisparoAnimacion(DefensaView torre, int anchoTile, int altoTile) {
        super(torre, anchoTile, altoTile);
        this.setPrefWidth(anchoTile / 2);
        this.setPrefHeight(altoTile / 2);
        this.setBackground(super.nuevoFondoDeImagen("/disparo.png"));
        this.imagenesExplosion = new ArrayList<>();
        this.inicializarImagenesExplocion();

    }

    private void inicializarImagenesExplocion(){
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion1.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion2.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion3.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion4.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion5.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion7.png"));
    }

    public void realizarAtaque(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY) {
        super.reproducirSonido("/disparo2.mp3", 2, 1);
        this.setVisible(true);
        TranslateTransition animacion = new TranslateTransition(Duration.millis(600), this);
        Entidad pasarelaAtacada = super.devolverParcela(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
        double posicionAtacadaX = pasarelaAtacada.getLayoutX() ;
        double posicionAtacadaY = pasarelaAtacada.getLayoutY() ;
        double recorridoAtacarX = posicionAtacadaX - this.getLayoutX() + 15;
        double recorridoAtacarY = posicionAtacadaY - this.getLayoutY();

        animacion.setToX(recorridoAtacarX);
        animacion.setToY(recorridoAtacarY);
        animacion.setCycleCount(2);
        animacion.setDelay(Duration.millis(200));
        animacion.setOnFinished( (finish) -> {this.transicionExplosion();});
        animacion.play();

        contenedor.getChildren().add(this);
    }
    private void transicionExplosion(){
        this.setBackground(this.imagenesExplosion.get(0));
        this.reproducirSonido("/explosion.mp3", 1, 1);
        ScaleTransition explocionAnimacion = new ScaleTransition(Duration.millis(600), this);
        explocionAnimacion.setToX(3);
        explocionAnimacion.setToY(3);
        explocionAnimacion.setCycleCount(1);
        explocionAnimacion.setDelay(Duration.millis(200));
        explocionAnimacion.play();
        explocionAnimacion.setOnFinished( (finish) -> {this.transicionDesaparecer(0);});
    }
    private void transicionDesaparecer(int index){

        if(index < this.imagenesExplosion.size()) {
            this.setBackground(this.imagenesExplosion.get(index));
            FadeTransition desaparecer = new FadeTransition(Duration.millis(300), this);
            desaparecer.setCycleCount(1);
            desaparecer.play();
            int finalIndex = index + 1;
            desaparecer.setOnFinished( (finish) -> {this.transicionDesaparecer(finalIndex);});
        }else{
            this.setBackground(this.imagenesExplosion.get(index-1));
            FadeTransition desaparecer = new FadeTransition(Duration.millis(400), this);
            desaparecer.setToValue(0);
            desaparecer.setCycleCount(1);
            desaparecer.play();
        }
    }
}
