package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
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


public class PartidaViewController implements Observador {
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


    private Logger logger;
    private Jugador jugadorModelo;
    private Partida partidaModelo;


    public Scene InicializarPartidaView(String urlInformacionDeMapa){

        this.inicializarModelo();

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

    private void inicializarModelo(){
        this.logger = new Logger();

        this.jugadorModelo = new Jugador("Jugador1");
        Mapa mapaModelo = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json").crearMapa();
        Turno turnoModelo = new Turno(this.jugadorModelo, mapaModelo);

        this.jugadorModelo.agregarObservador(this.logger);
        mapaModelo.agregarObservador(this.logger);
        turnoModelo.agregarObservador(this.logger);

        mapaModelo.agregarObservador(this);

        this.partidaModelo = new Partida(mapaModelo, this.jugadorModelo, turnoModelo);
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


        this.inicializarListenersBotonAgregarTorre (botonAgregarTorreBlanca, "/torreBlanca2.png");
        this.inicializarListenersBotonAgregarTorre (botonAgregarTorrePlateada, "/torrePlateada2.png");
        this.inicializarListenersBotonAgregarTrampaArena (botonAgregarTrampaArena);
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
    private void agregarTorreAlMapa(String urlImagenDeDefensa, Torre torreModelo, int x, int y){

        DefensaView torreVista = new TorreView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        this.mapa.add(torreVista, x, y);

        torreModelo.agregarObservador(logger);
        torreModelo.agregarObservador(torreVista);

        this.jugadorModelo.construirDefensa(torreModelo);
    }

    private void agregarTrampaArenaAlMapa(TrampaArena trampaModelo, int x, int y){

        DefensaView trampaVista = new TrampaArenaView("/trampaArena.png", this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y);
        this.mapa.add(trampaVista, x, y);

        trampaModelo.agregarObservador(logger);
        trampaModelo.agregarObservador(trampaVista);

        this.jugadorModelo.construirDefensa(trampaModelo);
    }

    private void inicializarEfectosBotonAgregar(Button boton){
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    boton.setEffect(new DropShadow());
                    boton.setEffect(new Glow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    boton.setEffect(null);
                });
    }
    private void inicializarListenersBotonAgregarTrampaArena(Button boton){

        inicializarEfectosBotonAgregar(boton);
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    int x = (int)parcelaElegida.getX();
                    int y = (int)parcelaElegida.getY();
                    TrampaArena trampaArena = new TrampaArena(new Posicion (x,y));
                    this.agregarTrampaArenaAlMapa(trampaArena, x,y);
                }
        );
    }
    private void inicializarListenersBotonAgregarTorre(Button boton, String urlImagenTorre){

        inicializarEfectosBotonAgregar(boton);
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    int x = (int)parcelaElegida.getX();
                    int y = (int)parcelaElegida.getY();
                    Torre torreBlanca = new TorreBlanca(new Posicion(x, y));
                    this.agregarTorreAlMapa(urlImagenTorre, torreBlanca, x,y);
                }
                );
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
                    this.partidaModelo.avanzarTurno();
                });
    }


    @Override
    public void actualizar(Observable observable, Object argument) {
        if(argument instanceof Hormiga){
            enemigo =new HormigaView(this.tamanioDelTileAncho, this.tamanioDelTileAlto,
                    0,1);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
        if(argument instanceof Arania){
            enemigo =new AraniaView(this.tamanioDelTileAncho, this.tamanioDelTileAlto,
                    0,1);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
        if(argument instanceof Topo){
            enemigo =new TopoView(this.tamanioDelTileAncho, this.tamanioDelTileAlto,
                    0,1);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
    }
}


