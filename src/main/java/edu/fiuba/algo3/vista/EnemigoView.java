package edu.fiuba.algo3.vista;

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


public class EnemigoView extends ImageView {

    private BufferedImage img;
    private ArrayList<Image> sprites = new ArrayList<>();
    private TranslateTransition translateTransitionDerecha;
    private TranslateTransition translateTransitionAbajo;
    private Queue<MovimientoEnemigoView> colaMovimientos;
    private boolean enMovimiento;
    public EnemigoView(String urlEnemigoImagen, int anchoTile, int altoTile, int x, int y) {

        this.colaMovimientos = new LinkedList<>();
        this.enMovimiento = false;

        try{
            this.img = ImageIO.read(getClass().getResourceAsStream(urlEnemigoImagen));
        } catch (IOException e){
            e.printStackTrace();
        }

        loadSprites();

        setImage(sprites.get(0));
        setX(x);
        setY(y);
        setFitHeight((double)altoTile);
        setFitWidth((double)anchoTile);

    }

    public void moverseDerecha(int nuevaX) {

        translateTransitionDerecha = new TranslateTransition(Duration.seconds(2),this);
        translateTransitionDerecha.setToX(nuevaX - getX());
        translateTransitionDerecha.setOnFinished(event -> {
            this.enMovimiento = false;
            procesarProximoMovimiento();
        });

        agregarMovimiento(new MovimientoEnemigoView(translateTransitionDerecha, sprites.get(2)));


    }

    public void moverseAbajo(int nuevaY){

        translateTransitionAbajo = new TranslateTransition(Duration.seconds(2),this);
        translateTransitionAbajo.setToY(nuevaY-getY());
        translateTransitionAbajo.setOnFinished(event -> {
            this.enMovimiento = false;
            procesarProximoMovimiento();
        });

        agregarMovimiento(new MovimientoEnemigoView(translateTransitionAbajo, sprites.get(0)));
    }

    public void agregarMovimiento(MovimientoEnemigoView movimiento){
        this.colaMovimientos.add(movimiento);
        procesarProximoMovimiento();
    }

    private void procesarProximoMovimiento(){

        if(!this.enMovimiento && !this.colaMovimientos.isEmpty()) {
            MovimientoEnemigoView proximoMovimiento = colaMovimientos.poll();
            if (proximoMovimiento != null) {
                this.enMovimiento = true;
                proximoMovimiento.correrMovimiento();
            }
        }
    }


    private void loadSprites(){
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                BufferedImage subimg = img.getSubimage(i*125,j*125,125,125);
                Image nueva = convertirImagen(subimg);
                sprites.add(nueva);
            }
        }
    }

    private Image convertirImagen(BufferedImage imagen){
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

}
