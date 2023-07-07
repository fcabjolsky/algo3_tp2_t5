package edu.fiuba.algo3.vista;

import javafx.animation.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class DisparoAnimacion extends DefensaAtaquesView{

    ArrayList<Background> imagenesExplosion;
    DefensaView torre;

    int anchoTile;
    int altoTile;

    public DisparoAnimacion(DefensaView torre, int anchoTile, int altoTile) {
        super(torre);
        this.torre = torre;
        this.anchoTile = anchoTile;
        this.altoTile = altoTile;
        this.setPrefWidth(anchoTile / 2);
        this.setPrefHeight(altoTile / 2);
        this.imagenesExplosion = new ArrayList<>();
        this.inicializarImagenesExplocion();
        this.setBackground(super.nuevoFondoDeImagen("/disparo.png"));
        System.out.println("la posicion inicial es: " + this.getLayoutX());
    }

    private void inicializarImagenesExplocion(){
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion1.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion2.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion3.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion4.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion5.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion7.png"));
    }

    public void realizarAtaque(Entidad pasarelaAtacada, Pane contenedor) {
        contenedor.getChildren().add(this);
        System.out.println("entre 1 ");
        super.reproducirSonido("/disparo2.mp3", 2, 1);
        TranslateTransition animacion = new TranslateTransition(Duration.millis(600), this);
        double posicionAtacadaX = pasarelaAtacada.getLayoutX() ;
        double posicionAtacadaY = pasarelaAtacada.getLayoutY() ;
        double recorridoAtacarX = posicionAtacadaX - this.getLayoutX() + 15;
        double recorridoAtacarY = posicionAtacadaY - this.getLayoutY();

        animacion.setToX(recorridoAtacarX);
        animacion.setToY(recorridoAtacarY);
        animacion.setCycleCount(2);
        animacion.setDelay(Duration.millis(200));
        animacion.setOnFinished( (finish) -> {this.transicionExplosion(contenedor);
        });
        animacion.play();
    }
    private void transicionExplosion(Pane contenedor){
        System.out.println("entre 2 ");
        this.setBackground(this.imagenesExplosion.get(0));
        this.reproducirSonido("/explosion.mp3", 1, 1);
        ScaleTransition explocionAnimacion = new ScaleTransition(Duration.millis(600), this);
        explocionAnimacion.setToX(3);
        explocionAnimacion.setToY(3);
        explocionAnimacion.setCycleCount(1);
        explocionAnimacion.setDelay(Duration.millis(200));
        explocionAnimacion.play();
        explocionAnimacion.setOnFinished( (finish) -> {this.transicionDesaparecer(0, contenedor);
        });
    }
    private void transicionDesaparecer(int index, Pane contenedor){

        if(index < this.imagenesExplosion.size()) {
            System.out.println("entre 3 ");
            this.setBackground(this.imagenesExplosion.get(index));
            FadeTransition desaparecer = new FadeTransition(Duration.millis(300), this);
            desaparecer.play();
            int finalIndex = index + 1;
            desaparecer.setOnFinished( (finish) -> {this.transicionDesaparecer(finalIndex, contenedor);});
        }else{
            System.out.println("entre 4");
            this.setBackground(this.imagenesExplosion.get(index-1));
            FadeTransition desaparecer = new FadeTransition(Duration.millis(400), this);
            desaparecer.setToValue(0);
            desaparecer.setCycleCount(1);
            desaparecer.play();
            desaparecer.setOnFinished( (finish) -> {contenedor.getChildren().remove(this);});
        }
    }
}
