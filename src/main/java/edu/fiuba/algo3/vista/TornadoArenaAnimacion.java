package edu.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class TornadoArenaAnimacion extends DefensaAtaquesView{
    public TornadoArenaAnimacion(DefensaView torre, int anchoTile, int altoTile) {
        super(torre, anchoTile, altoTile);
        this.setPrefWidth(anchoTile);
        this.setPrefHeight(altoTile);
        this.setBackground(super.nuevoFondoDeImagen("/trampaArenaTornado.png"));
    }

    @Override
    public void realizarAtaque(Entidad pasarelaAtacada) {
        this.setVisible(true);
        super.reproducirSonido("/viento.mp3", 1, 1);
        TranslateTransition animacion = new TranslateTransition(Duration.millis(900), this);
        double posicionAtacadaX = pasarelaAtacada.getLayoutX() ;

        animacion.setToX(posicionAtacadaX - 20);
        animacion.setToX(posicionAtacadaX + 20);
        animacion.setAutoReverse(true);
        animacion.setCycleCount(2);

        ScaleTransition agrandarTornado = new ScaleTransition(Duration.millis(600), this);
        agrandarTornado.setToX(1.5);
        agrandarTornado.setCycleCount(1);

        ParallelTransition animacionesJuntas = new ParallelTransition(animacion, agrandarTornado);
        animacionesJuntas.setDelay(Duration.millis(200));
        animacionesJuntas.play();

        animacionesJuntas.setOnFinished( (finish) -> {
            FadeTransition desaparecer = new FadeTransition(Duration.millis(400), this);
            desaparecer.setToValue(0);
            desaparecer.setCycleCount(1);
            desaparecer.play();
        });
    }
}
