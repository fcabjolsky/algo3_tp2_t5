package edu.fiuba.algo3.vista;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;


public class PartidaViewController{
    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    final int maximoDeColumnas = 15;
    final int maximoDeFilas = 15;
    final int tamanioDelTileAncho = (anchoDePantalla/maximoDeColumnas) - 5;
    final int tamanioDelTileAlto = (altoDePantalla/maximoDeFilas);

    static Entidad parcelaElegida;
    @FXML
    private Pane panelBotones;
    @FXML
    private GridPane mapa;
    
    private AnchorPane contenedor;
    private ParcelaManager paisaje;

    private EnemigoView enemigo; //ahora cuando todavia no esta unido el modelo

    public Scene InicializarPartidaView(String urlInformacionDeMapa){
        int altoDeBoton = 75;

        Button botonSalirYGuardar = new Button();
        Button botonAgregarTorreBlanca = new Button();
        Button botonAgregarTorrePlateada = new Button();
        Button botonAgregarTrampaArena = new Button();
        Button botonPasarTurno = new Button();

        this.setEstiloBoton("/botonSalirSoltado.png",botonSalirYGuardar, -8, -7, 40);
        this.setEstiloBoton("/botonTorreBlanca.png", botonAgregarTorreBlanca, -8, 170, altoDeBoton);
        this.setEstiloBoton("/botonTorrePlateada.png", botonAgregarTorrePlateada,-8 , 255, altoDeBoton);
        this.setEstiloBoton("/botonTrampaArena.png", botonAgregarTrampaArena, -8, 340, altoDeBoton);
        this.setEstiloBotonPasarTurno(botonPasarTurno);

        this.inicializarListenersBotonAgregar(botonAgregarTorreBlanca, "/torreBlanca.png");
        this.inicializarListenersBotonAgregar(botonAgregarTorrePlateada, "/torrePlateada2.png");
        this.inicializarListenersBotonAgregar(botonAgregarTrampaArena, "/trampaArena.png");
        this.inicializarListenersBotonSalir(botonSalirYGuardar);
        this.inicializarListenersBotonPasarTurno(botonPasarTurno);

        this.panelBotones = new Pane(botonSalirYGuardar, botonAgregarTorreBlanca, botonAgregarTorrePlateada, botonAgregarTrampaArena, botonPasarTurno);
        this.panelBotones.setPrefHeight(altoDePantalla);
        this.panelBotones.setPrefWidth(75);
        this.panelBotones.setLayoutX(720);
        this.panelBotones.setLayoutY(0);
        this.panelBotones.setBorder(Border.EMPTY);
        this.panelBotones.setStyle("-fx-background-image: url('/fondoPiedra.jpg'); -fx-background-size: 90 "+altoDePantalla+";");


        this.mapa = new GridPane();

        this.inicializarContenedorDeMapa(urlInformacionDeMapa);

        this.contenedor = new AnchorPane(this.mapa, this.panelBotones);

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

    private void setEstiloBotonPasarTurno(Button botonPasarTurno){
        botonPasarTurno.setLayoutX(-8);
        botonPasarTurno.setLayoutY(430);
        botonPasarTurno.setStyle("    -fx-background-color: #9b2e2a;"+
                "    -fx-text-fill: white;");
        botonPasarTurno.setText("Pasar turno");

    }

    private void agregarTorreAMapa(String urlImagenTorre){
        int x = (int)parcelaElegida.getX();
        int y = (int)parcelaElegida.getY();
        DefensaView torreAAgregar = new DefensaView(urlImagenTorre, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        ((TierraView)parcelaElegida).setTorre(torreAAgregar);
        this.mapa.add(torreAAgregar, x, y);
    }

    private void mostrarNuevosEnemigos(){
        this.enemigo =new EnemigoView("/spriteHormiga.png", this.tamanioDelTileAncho, this.tamanioDelTileAlto,
                1*this.tamanioDelTileAncho,0*tamanioDelTileAlto);
        contenedor.getChildren().add(enemigo);
    }

    private void avanzarViejosEnemigos(){
        this.enemigo.moverseAbajo(6*tamanioDelTileAlto);
        this.enemigo.moverseDerecha(8*tamanioDelTileAncho);
        this.enemigo.moverseAbajo(10*tamanioDelTileAlto);
    }

    private void inicializarListenersBotonPasarTurno(Button boton){
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
                    mostrarNuevosEnemigos();
                    avanzarViejosEnemigos();
                });
    }
    private void inicializarListenersBotonAgregar(Button boton, String urlImagenDefensa){
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
                    agregarTorreAMapa(urlImagenDefensa);
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


