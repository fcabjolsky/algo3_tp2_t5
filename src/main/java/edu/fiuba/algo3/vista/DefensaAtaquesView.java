package edu.fiuba.algo3.vista;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public abstract class DefensaAtaquesView extends Region {

    public DefensaAtaquesView(DefensaView torre, int anchoTile, int altoTile) {
        this.setVisible(false);
        this.setLayoutX(torre.getLayoutX() * anchoTile);
        this.setLayoutY(torre.getLayoutY() * altoTile);
    }

    private Node obtenerParcelaDeMapa(GridPane mapa, int x, int y) {
        ObservableList<Node> parcelas = mapa.getChildren();
        for (Node nodo : parcelas) {
            Integer columnaIndex = GridPane.getColumnIndex(nodo);
            Integer filaIndex = GridPane.getRowIndex(nodo);
            if (columnaIndex == null){
                columnaIndex = 0;
            }
            if (filaIndex == null){
                filaIndex = 0;
            }
            if (columnaIndex == x && filaIndex == y){
                return nodo;
            }
        }
        return null;
    }
    protected Entidad devolverParcela(GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY){
        Entidad parcelaADevolver = null;
        try {
            parcelaADevolver = (PasarelaView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
        }catch(ClassCastException errorDeClase){
            try {
                parcelaADevolver = (TierraView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
            }catch(ClassCastException errorDeClase2){
                parcelaADevolver = (RocosoView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
            }
        }
        return parcelaADevolver;
    }
    protected Background nuevoFondoDeImagen(String urlImagen){
        Image imagen = (new Image(DisparoAnimacion.class.getResourceAsStream(urlImagen)));
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getPrefWidth(), this.getPrefHeight(), false, false, true, true));
        return new Background(fondo);
    }
    public abstract void realizarAtaque(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY);

    protected void reproducirSonido(String urlSonido, int veces, int velocidad){

        AudioClip sonido = new AudioClip(getClass().getResource(urlSonido).toString());
        sonido.setCycleCount(veces);
        sonido.setRate(velocidad);
        sonido.play();

    }
}
