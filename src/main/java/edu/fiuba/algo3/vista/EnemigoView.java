package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public abstract class EnemigoView extends ImageView implements Observador {

    protected BufferedImage img;
    protected ArrayList<Image> sprites = new ArrayList<>();
    protected TranslateTransition translateTransitionDerecha;
    protected TranslateTransition translateTransitionAbajo;
    protected Queue<MovimientoEnemigoView> colaMovimientos;
    protected boolean enMovimiento;
    protected final int anchoTile;
    protected final int altoTile;
    public EnemigoView(String urlEnemigoImagen, int anchoTile, int altoTile, int x, int y) {
        this.altoTile = altoTile;
        this.anchoTile = anchoTile;

        this.colaMovimientos = new LinkedList<>();
        this.enMovimiento = false;

        try{
            this.img = ImageIO.read(getClass().getResourceAsStream(urlEnemigoImagen));
        } catch (IOException e){
            e.printStackTrace();
        }

        loadSprites();

        setImage(imagenMovimientoAbajo());
        setX(x*this.anchoTile);
        setY(y*this.altoTile);
        setFitHeight((double)altoTile);
        setFitWidth((double)anchoTile);

    }

    protected void moverseDerecha(int nuevaX) {

        translateTransitionDerecha = new TranslateTransition(Duration.seconds(0.5),this);
        translateTransitionDerecha.setToX(nuevaX*this.anchoTile - getX());
        translateTransitionDerecha.setOnFinished(event -> {
            this.enMovimiento = false;
            procesarProximoMovimiento();
        });

        agregarMovimiento(new MovimientoEnemigoView(translateTransitionDerecha, imagenMovimientoDerecha()));


    }

    protected void moverseAbajo(int nuevaY){

        translateTransitionAbajo = new TranslateTransition(Duration.seconds(0.5),this);
        translateTransitionAbajo.setToY(nuevaY*this.altoTile-getY());
        translateTransitionAbajo.setOnFinished(event -> {
            this.enMovimiento = false;
            procesarProximoMovimiento();
        });

        agregarMovimiento(new MovimientoEnemigoView(translateTransitionAbajo, imagenMovimientoAbajo()));
    }

    public void agregarMovimiento(MovimientoEnemigoView movimiento){
        this.colaMovimientos.add(movimiento);
        procesarProximoMovimiento();
    }

    protected void procesarProximoMovimiento(){

        if(!this.enMovimiento && !this.colaMovimientos.isEmpty()) {
            MovimientoEnemigoView proximoMovimiento = colaMovimientos.poll();
            if (proximoMovimiento != null) {
                this.enMovimiento = true;
                proximoMovimiento.correrMovimiento();
            }
        }
    }


    protected Image convertirImagen(BufferedImage imagen){
        int ancho = imagen.getWidth();
        int largo = imagen.getHeight();

        WritableImage nueva = new WritableImage(ancho, largo);
        PixelWriter convertidor = nueva.getPixelWriter();

        int[] datos = new int[ancho*largo];
        imagen.getRGB(0,0,ancho,largo,datos,0,ancho);

        for(int y = 0; y < largo; y++){
            for(int x = 0; x < ancho; x++){
                int pixel = datos[y*ancho+x];
                convertidor.setArgb(x,y,pixel);
            }
        }

        return nueva;
    }

    protected abstract void loadSprites();

    protected abstract Image imagenMovimientoAbajo();
    protected abstract Image imagenMovimientoDerecha();

    @Override
    public void actualizar(Observable observable, Object argument){
        if(argument instanceof Posicion){
            if(((Posicion) argument).getCoordenadaX() > getX()/this.anchoTile){
                this.moverseDerecha(((Posicion) argument).getCoordenadaX());
            }
            if(((Posicion) argument).getCoordenadaY() > getY()/this.altoTile){
                this.moverseAbajo(((Posicion) argument).getCoordenadaY());
            }
        }
        if (argument instanceof Boolean){
            this.setImage(null);
        }
    }

}
