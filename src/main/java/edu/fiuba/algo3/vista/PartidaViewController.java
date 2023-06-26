package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Posicion;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;


public class PartidaViewController{
    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    final int maximoDeColumnas = 15;
    final int maximoDeFilas = 15;
    final int tamanioDelTileAncho = (anchoDePantalla/maximoDeColumnas) - 5;
    final int tamanioDelTileAlto = (altoDePantalla/maximoDeFilas);

    static Posicion posicionParcela = new Posicion(0,0);
    @FXML
    private Pane panelBotones;
    @FXML
    private GridPane mapa;

    @FXML
    private GridPane torres;
    private ParcelaManager paisaje;

    public Scene InicializarPartidaView(String urlInformacionDeMapa){
        int altoDeBoton = 75;

        Button botonSalirYGuardar = new Button();
        Button botonAgregarTorreBlanca = new Button();
        Button botonAgregarTorrePlateada = new Button();
        Button botonAgregarTrampaArena = new Button();

        this.setEstiloBoton("/botonSalirSoltado.png",botonSalirYGuardar, -8, -7, 40);
        this.setEstiloBoton("/botonTorreBlanca.png", botonAgregarTorreBlanca, -8, 170, altoDeBoton);
        this.setEstiloBoton("/botonTorrePlateada.png", botonAgregarTorrePlateada,-8 , 255, altoDeBoton);
        this.setEstiloBoton("/botonTrampaArena.png", botonAgregarTrampaArena, -8, 340, altoDeBoton);

        this.inicializarListenersBotonAgregar(botonAgregarTorreBlanca);
        this.inicializarListenersBotonAgregar(botonAgregarTorrePlateada);
        this.inicializarListenersBotonAgregar(botonAgregarTrampaArena);
        this.inicializarListenersBotonSalir(botonSalirYGuardar);

        this.panelBotones = new Pane(botonSalirYGuardar, botonAgregarTorreBlanca, botonAgregarTorrePlateada, botonAgregarTrampaArena);
        this.panelBotones.setPrefHeight(altoDePantalla);
        this.panelBotones.setPrefWidth(75);
        this.panelBotones.setLayoutX(720);
        this.panelBotones.setLayoutY(0);
        this.panelBotones.setBorder(Border.EMPTY);
        this.panelBotones.setStyle("-fx-background-image: url('/fondoPiedra.jpg'); -fx-background-size: 90 "+altoDePantalla+";");


        this.mapa = new GridPane();
        this.torres = new GridPane();
        this.torres.setBackground(Background.EMPTY);
        this.torres.setLayoutX(0);
        this.torres.setLayoutY(0);
        this.torres.setPrefHeight(altoDePantalla);
        this.torres.setPrefWidth(anchoDePantalla - 75);

        this.inicializarContenedorDeMapa(urlInformacionDeMapa);

        AnchorPane contenedor = new AnchorPane(this.mapa, this.panelBotones);

        Scene partida = new Scene(contenedor);

        return partida;
    }

    private void inicializarContenedorDeMapa(String urlInformacionDeMapa){
        this.mapa.setLayoutY(0);
        this.mapa.setLayoutX(0);
        this.mapa.prefHeight(altoDePantalla);
        this.mapa.prefWidth(anchoDePantalla - 75);

        this.paisaje = new ParcelaManager(this.mapa, urlInformacionDeMapa, this.maximoDeColumnas, this.maximoDeFilas);
        this.paisaje.inicializarPaisaje(this.mapa,this.tamanioDelTileAlto, this.tamanioDelTileAncho);
    }

    private void setEstiloBoton(String urlFondo, Button boton, int x, int y, int alto){
        URL fondo = getClass().getResource(urlFondo);
        boton.setGraphic(new ImageView(new Image(fondo.toString(), 75, alto, false, false)));
        boton.setBackground(Background.EMPTY);
        boton.setPrefHeight(alto);
        boton.setPrefWidth(75);
        boton.setLayoutX(x);
        boton.setLayoutY(y);
    }

    private void agregarTorreAMapa(String urlImagenTorre){
        System.out.println(posicionParcela.getCoordenadaX());
        int x = posicionParcela.getCoordenadaX();
        int y = posicionParcela.getCoordenadaY();
        TorreView torreAAgregar = new TorreView(urlImagenTorre, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        this.torres.getChildren().add(torreAAgregar);
    }
    private void inicializarListenersBotonAgregar(Button boton){
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    boton.setEffect(new DropShadow());
                    boton.setEffect(new Glow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    boton.setEffect(null);
                });
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    agregarTorreAMapa("/torreBlanca.png");
                });
    }
    private void inicializarListenersBotonSalir(Button boton){
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    setEstiloBoton("/botonSalirPresionado.png", boton,-8, -7, 40);
                    boton.setEffect(new DropShadow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    setEstiloBoton("/botonSalirSoltado.png", boton,-8, -7, 40);
                    boton.setEffect(null);
                });
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    Stage stage = (Stage) boton.getScene().getWindow();
                    stage.close();
                });
    }
}


