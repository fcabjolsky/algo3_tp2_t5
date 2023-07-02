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
    private ParcelaManager paisaje;
    @FXML
    private AnchorPane contenedor;

    private BarraDeVida vidaPersonaje;

    private Creditos creditosPersonaje;

    private EnemigoView enemigo; //ahora cuando todavia no esta unido el modelo

    public Scene InicializarPartidaView(String urlInformacionDeMapa){

        this.inicializarBotones();
        this.inicializarPanelBotones();

        this.mapa = new GridPane();
        this.inicializarContenedorDeMapa(urlInformacionDeMapa);

        this.vidaPersonaje = new BarraDeVida();
        this.creditosPersonaje = new Creditos();

        this.contenedor = new AnchorPane();
        this.contenedor.getChildren().addAll(this.mapa, this.panelBotones);
        this.contenedor.getChildren().addAll(this.vidaPersonaje, this.creditosPersonaje);

        Scene partida = new Scene(this.contenedor);

        return partida;
    }

    private void inicializarBotones(){
        int altoDeBoton = 75;

        Button botonSalirYGuardar = new Button();
        Button botonAgregarTorreBlanca = new Button();
        Button botonAgregarTorrePlateada = new Button();
        Button botonAgregarTrampaArena = new Button();
        Button botonPasarTurno = new Button();

        this.setEstiloBoton("/botonSalirSoltado.png",botonSalirYGuardar, -8, -7, 40);
        this.setEstiloBoton("/botonPasarTurnoSoltado.png",botonPasarTurno, -8, 500, altoDeBoton);
        this.setEstiloBoton("/botonTorreBlanca.png", botonAgregarTorreBlanca, -8, 170, altoDeBoton);
        this.setEstiloBoton("/botonTorrePlateada.png", botonAgregarTorrePlateada,-8 , 255, altoDeBoton);
        this.setEstiloBoton("/botonTrampaArena.png", botonAgregarTrampaArena, -8, 340, altoDeBoton);


        this.inicializarListenersBotonAgregar(botonAgregarTorreBlanca, "/torreBlanca2.png", true);
        this.inicializarListenersBotonAgregar(botonAgregarTorrePlateada, "/torrePlateada2.png", true);
        this.inicializarListenersBotonAgregar(botonAgregarTrampaArena, "/trampaArena.png", false);
        this.inicializarListenersBotonSalir(botonSalirYGuardar);
        this.inicializarListenersBotonPasarTurno(botonPasarTurno);

        this.panelBotones = new Pane(botonSalirYGuardar, botonAgregarTorreBlanca,
                botonAgregarTorrePlateada, botonAgregarTrampaArena, botonPasarTurno);
    }

    private void inicializarPanelBotones(){

        this.panelBotones.setPrefHeight(altoDePantalla);
        this.panelBotones.setPrefWidth(75);
        this.panelBotones.setLayoutX(720);
        this.panelBotones.setLayoutY(0);
        this.panelBotones.setBorder(Border.EMPTY);
        this.panelBotones.setStyle("-fx-background-image: url('/fondoPiedra.jpg'); -fx-background-size: 90 "+altoDePantalla+";");

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

    private void agregarDefensaAlMapa(String urlImagenDeDefensa, boolean esTorre){
        DefensaView defensaAAgregar;
        int x = (int)parcelaElegida.getX();
        int y = (int)parcelaElegida.getY();
        if(esTorre){
            defensaAAgregar = new TorreView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        }else{
            defensaAAgregar = new TrampaArenaView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        }
        this.mapa.add(defensaAAgregar, x, y);
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

    private void inicializarListenersBotonAgregar(Button boton, String urlImagenDefensa, boolean esTorre){

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
                    agregarDefensaAlMapa(urlImagenDefensa, esTorre);
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

    private void inicializarListenersBotonPasarTurno(Button boton){
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    setEstiloBoton("/botonPasarTurnoPresionado.png", boton,-8, 500, 75);
                    boton.setEffect(new DropShadow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    setEstiloBoton("/botonPasarTurnoSoltado.png", boton,-8, 500, 75);
                    boton.setEffect(null);
                });
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    mostrarNuevosEnemigos();
                    avanzarViejosEnemigos();
                });
    }


}


