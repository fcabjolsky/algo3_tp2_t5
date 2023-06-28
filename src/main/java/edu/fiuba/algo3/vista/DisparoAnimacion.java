package edu.fiuba.algo3.vista;

import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class DisparoAnimacion extends Region{

    DefensaView torre;
    int anchoTile;
    int altoTile;

    ArrayList<Background> imagenesExplosion;

    public DisparoAnimacion(DefensaView torre, int anchoTile, int altoTile) {
        this.setBackground(this.nuevoFondoDeImagen("/disparo.png"));
        this.torre = torre;
        this.imagenesExplosion = new ArrayList<>();
        this.inicializarImagenesExplocion();
        this.setLayoutX(torre.getLayoutX() * anchoTile);
        this.setLayoutY(torre.getLayoutY() * altoTile);
        this.anchoTile = anchoTile;
        this.altoTile = altoTile;
        System.out.println(this.getLayoutX() +" : "+ this.getLayoutY());
        this.setPrefWidth(anchoTile/2);
        this.setPrefHeight(altoTile/2);
        this.setVisible(false);
    }

    private void inicializarImagenesExplocion(){
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion1.png"));
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion2.png"));
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion3.png"));
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion4.png"));
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion5.png"));
        this.imagenesExplosion.add(this.nuevoFondoDeImagen("/explosion7.png"));
    }

    public void realizarAtaque(Pane contenedor, GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY) {
        this.setVisible(true);
        TranslateTransition animacion = new TranslateTransition(Duration.millis(600), this);
        Entidad pasarelaAtacada = this.devolverParcela(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
        double posicionAtacadaX = pasarelaAtacada.getLayoutX() ;
        double posicionAtacadaY = pasarelaAtacada.getLayoutY() ;
        double recorridoAtacarX = posicionAtacadaX - this.getLayoutX() + 15;
        double recorridoAtacarY = posicionAtacadaY - this.getLayoutY();

        animacion.setToX(recorridoAtacarX);
        animacion.setToY(recorridoAtacarY);
        animacion.setCycleCount(2);
        animacion.setOnFinished( (finish) -> {this.transicionExplosion();});
        animacion.play();

        contenedor.getChildren().add(this);
    }
    private void transicionExplosion(){
        this.setBackground(this.nuevoFondoDeImagen("/explosion1.png"));
        ScaleTransition explocionAnimacion = new ScaleTransition(Duration.millis(600), this);
        explocionAnimacion.setToX(3);
        explocionAnimacion.setToY(3);
        explocionAnimacion.setCycleCount(1);
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

    private Background nuevoFondoDeImagen(String urlImagen){
        Image imagen = (new Image(DisparoAnimacion.class.getResourceAsStream(urlImagen)));
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getPrefWidth(), this.getPrefHeight(), false, false, true, true));
        return new Background(fondo);
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
    private Entidad devolverParcela(GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY){
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
}
