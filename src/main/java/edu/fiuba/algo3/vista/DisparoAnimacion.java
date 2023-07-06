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
    DefensaView torre;

    int anchoTile;
    int altoTile;

    double recorridoAtacarX;
    double recorridoAtacarY;

    public DisparoAnimacion(DefensaView torre, int anchoTile, int altoTile) {
        super(torre, anchoTile, altoTile);
        this.torre = torre;
        this.anchoTile = anchoTile;
        this.altoTile = altoTile;
        this.setPrefWidth(anchoTile / 2);
        this.setPrefHeight(altoTile / 2);
        this.imagenesExplosion = new ArrayList<>();
        this.inicializarImagenesExplocion();
        System.out.println("la posicion inicial es: " + this.getLayoutY());
    }

    private void inicializarImagenesExplocion(){
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion1.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion2.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion3.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion4.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion5.png"));
        this.imagenesExplosion.add(super.nuevoFondoDeImagen("/explosion7.png"));
    }

    public void realizarAtaque(Entidad pasarelaAtacada) {
        this.setBackground(super.nuevoFondoDeImagen("/disparo.png"));
        this.setVisible(true);
        System.out.println("entre 1 ");
        super.reproducirSonido("/disparo2.mp3", 2, 1);
        TranslateTransition animacion = new TranslateTransition(Duration.millis(600), this);
        double posicionAtacadaX = pasarelaAtacada.getLayoutX() ;
        double posicionAtacadaY = pasarelaAtacada.getLayoutY() ;
        this.recorridoAtacarX = posicionAtacadaX - this.getLayoutX() + 15;
        this.recorridoAtacarY = posicionAtacadaY - this.getLayoutY();

        animacion.setToX(recorridoAtacarX);
        animacion.setToY(recorridoAtacarY);
        animacion.setCycleCount(2);
        animacion.setDelay(Duration.millis(200));
        animacion.setOnFinished( (finish) -> {this.transicionExplosion();
        });
        animacion.play();
    }
    private void transicionExplosion(){
        System.out.println("entre 2 ");
        this.setBackground(this.imagenesExplosion.get(0));
        this.reproducirSonido("/explosion.mp3", 1, 1);
        ScaleTransition explocionAnimacion = new ScaleTransition(Duration.millis(600), this);
        explocionAnimacion.setToX(3);
        explocionAnimacion.setToY(3);
        explocionAnimacion.setCycleCount(1);
        explocionAnimacion.setDelay(Duration.millis(200));
        explocionAnimacion.play();
        explocionAnimacion.setOnFinished( (finish) -> {this.transicionDesaparecer(0);
        });
    }
    private void transicionDesaparecer(int index){

        if(index < this.imagenesExplosion.size()) {
            System.out.println("entre 3 ");
            this.setBackground(this.imagenesExplosion.get(index));
            FadeTransition desaparecer = new FadeTransition(Duration.millis(300), this);
            desaparecer.play();
            int finalIndex = index + 1;
            desaparecer.setOnFinished( (finish) -> {this.transicionDesaparecer(finalIndex);});
        }else{
            System.out.println("entre 4");
            this.setBackground(this.imagenesExplosion.get(index-1));
            ScaleTransition encoger = new ScaleTransition(Duration.millis(600), this);
            encoger.setToX(1);
            encoger.setToY(1);
            TranslateTransition animacion = new TranslateTransition(Duration.millis(10), this);
            System.out.println(this.recorridoAtacarY);
            animacion.setToX(this.recorridoAtacarX);
            animacion.setToY(this.getLayoutY() - this.recorridoAtacarY);
            animacion.setDelay(Duration.millis(10));
            ParallelTransition parallelTransition = new ParallelTransition(encoger, animacion);
            parallelTransition.play();
        }
    }
}
