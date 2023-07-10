package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.media.AudioClip;

public abstract class DefensaAtaquesView extends Region {

    public DefensaAtaquesView(DefensaView torre) {
        this.setVisible(true);
        System.out.println("La posicion de la torre segun el ataque es "+ torre.getLayoutX());
        this.setLayoutX(torre.getLayoutX());
        System.out.println("la posicion del ataque es: "+ this.getLayoutX());
        this.setLayoutY(torre.getLayoutY());
    }

    protected Background nuevoFondoDeImagen(String urlImagen){
        Image imagen = (new Image(DisparoAnimacion.class.getResourceAsStream(urlImagen)));
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getPrefWidth(), this.getPrefHeight(), false, false, true, true));
        return new Background(fondo);
    }
    public abstract void realizarAtaque(ParcelaView pasarelaAtacada, Pane contenedor);

    protected void reproducirSonido(String urlSonido, int veces, int velocidad){

        AudioClip sonido = new AudioClip(getClass().getResource(urlSonido).toString());
        sonido.setCycleCount(veces);
        sonido.setRate(velocidad);
        sonido.play();

    }
}
