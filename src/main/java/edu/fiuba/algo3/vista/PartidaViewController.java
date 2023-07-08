package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
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


public class PartidaViewController {
    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    final int maximoDeColumnas = 15;
    final int maximoDeFilas = 15;
    final int tamanioDelTileAncho = (anchoDePantalla / maximoDeColumnas) - 5;
    final int tamanioDelTileAlto = (altoDePantalla / maximoDeFilas);

    static Entidad parcelaElegida;
    @FXML
    private Pane panelBotones;
    @FXML
    private GridPane mapa;
    private ParcelaManager paisaje;
    @FXML
    private AnchorPane contenedor;

    private BarraDeVida vidaPersonaje;

    private CreditosView creditosPersonaje;

    private ControladorJuego controladorJuego;


    public Scene InicializarPartidaView(String urlInformacionDeMapa) {

        this.inicializarBotones();
        this.inicializarPanelBotones();

        this.mapa = new GridPane();
        this.inicializarContenedorDeMapa(urlInformacionDeMapa);

        this.vidaPersonaje = new BarraDeVida();
        this.creditosPersonaje = new CreditosView();

        this.contenedor = new AnchorPane();
        this.contenedor.getChildren().addAll(this.mapa, this.panelBotones);
        this.contenedor.getChildren().addAll(this.vidaPersonaje, this.creditosPersonaje);

        this.controladorJuego = new ControladorJuego(ElegirNombreViewController.nombreDeJugador, this.contenedor, this.mapa, this.tamanioDelTileAncho, this.tamanioDelTileAlto);
        this.controladorJuego.agregarObservadoresJugador(this.creditosPersonaje, this.vidaPersonaje);
        Scene partida = new Scene(this.contenedor);

        return partida;
    }

    private void inicializarBotones() {
        int altoDeBoton = 75;

        Button botonSalirYGuardar = new Button();
        Button botonAgregarTorreBlanca = new Button();
        Button botonAgregarTorrePlateada = new Button();
        Button botonAgregarTrampaArena = new Button();
        Button botonPasarTurno = new Button();

        this.setEstiloBoton("/botonSalirSoltado.png", botonSalirYGuardar, -8, -7, 40);
        this.setEstiloBoton("/botonPasarTurnoSoltado.png", botonPasarTurno, -8, 500, altoDeBoton);
        this.setEstiloBoton("/botonTorreBlanca.png", botonAgregarTorreBlanca, -8, 170, altoDeBoton);
        this.setEstiloBoton("/botonTorrePlateada.png", botonAgregarTorrePlateada, -8, 255, altoDeBoton);
        this.setEstiloBoton("/botonTrampaArena.png", botonAgregarTrampaArena, -8, 340, altoDeBoton);

        this.inicializarListenersBotonAgregar(botonAgregarTorreBlanca, "/torreBlanca2.png", true, true);
        this.inicializarListenersBotonAgregar(botonAgregarTorrePlateada, "/torrePlateada2.png", false, true);
        this.inicializarListenersBotonAgregar(botonAgregarTrampaArena, "/trampaArena.png", false, false);

        this.inicializarListenersBotonSalir(botonSalirYGuardar);
        this.inicializarListenersBotonPasarTurno(botonPasarTurno);

        this.panelBotones = new Pane(botonSalirYGuardar, botonAgregarTorreBlanca,
                botonAgregarTorrePlateada, botonAgregarTrampaArena, botonPasarTurno);
    }

    private void inicializarPanelBotones() {

        this.panelBotones.setPrefHeight(altoDePantalla);
        this.panelBotones.setPrefWidth(75);
        this.panelBotones.setLayoutX(720);
        this.panelBotones.setLayoutY(0);
        this.panelBotones.setBorder(Border.EMPTY);
        this.panelBotones.setStyle("-fx-background-image: url('/fondoPiedra.jpg'); -fx-background-size: 90 " + altoDePantalla + ";");

    }

    private void inicializarContenedorDeMapa(String urlInformacionDeMapa) {
        this.mapa.setLayoutY(0);
        this.mapa.setLayoutX(0);
        this.mapa.prefHeight(altoDePantalla);
        this.mapa.prefWidth(anchoDePantalla - 75);

        this.paisaje = new ParcelaManager(this.mapa, urlInformacionDeMapa, this.maximoDeColumnas, this.maximoDeFilas);
        this.paisaje.inicializarPaisaje(this.mapa, this.tamanioDelTileAlto, this.tamanioDelTileAncho);
    }

    private void setEstiloBoton(String urlFondo, Button boton, int x, int y, int alto) {
        URL fondo = getClass().getResource(urlFondo);
        boton.setGraphic(new ImageView(new Image(fondo.toString(), 75, alto, false, false)));
        boton.setBackground(Background.EMPTY);
        boton.setPrefHeight(alto);
        boton.setPrefWidth(75);
        boton.setLayoutX(x);
        boton.setLayoutY(y);
    }

    private void agregarDefensaAlMapa(String urlImagenDeDefensa, boolean esTorreBlanca, boolean esTorre) {
        DefensaView defensaAAgregar;
        int x = (int) parcelaElegida.getX();
        int y = (int) parcelaElegida.getY();
        try {
            if (esTorreBlanca) {
                defensaAAgregar = this.agregarTorreBlancaAMapa(urlImagenDeDefensa, x, y);
            } else if (esTorre) {
                defensaAAgregar = this.agregarTorrePlateadaAMapa(urlImagenDeDefensa, x, y);
            } else {
                defensaAAgregar = new TrampaArenaView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y, this.contenedor, this.mapa);
            }
            this.mapa.add(defensaAAgregar, x, y);
        } catch (NoDisponeDeSuficientesCreditos e) {
            AlertaView alertaCreditosInsuficientes = new AlertaView();
            alertaCreditosInsuficientes.lanzarAlerta("No dispone de suficientes creditos");
        }
    }

    private TorreView agregarTorreBlancaAMapa(String urlImagenDeDefensa, int x, int y) {
        try {
            TorreView torreBlanca = new TorreView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y, this.contenedor, this.mapa);
            TorreBlanca torre = new TorreBlanca(new Posicion(x, y), torreBlanca);
            this.controladorJuego.agregarDefensaAPartida(torre, this.creditosPersonaje);
            return torreBlanca;
        } catch (NoDisponeDeSuficientesCreditos e) {
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    private TorreView agregarTorrePlateadaAMapa(String urlImagenDeDefensa, int x, int y) {
        try {
            TorreView torrePlateada = new TorreView(urlImagenDeDefensa, this.tamanioDelTileAncho, this.tamanioDelTileAlto, x, y, this.contenedor, this.mapa);
            TorrePlateada torre = new TorrePlateada(new Posicion(x, y), torrePlateada);
            this.controladorJuego.agregarDefensaAPartida(torre, this.creditosPersonaje);
            return torrePlateada;
        } catch (NoDisponeDeSuficientesCreditos e) {
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    private void inicializarListenersBotonAgregar(Button boton, String urlImagenDefensa, boolean esTorreBlanca, boolean esTorre) {
        inicializarEfectosBotonAgregar(boton);
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    agregarDefensaAlMapa(urlImagenDefensa, esTorreBlanca, esTorre);
                }
        );
    }

    private void inicializarEfectosBotonAgregar(Button boton) {
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


    private void inicializarListenersBotonSalir(Button boton) {
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    setEstiloBoton("/botonSalirPresionado.png", boton, -8, -7, 40);
                    boton.setEffect(new DropShadow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    setEstiloBoton("/botonSalirSoltado.png", boton, -8, -7, 40);
                    boton.setEffect(null);
                });
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    Stage stage = (Stage) boton.getScene().getWindow();
                    stage.close();
                });
    }

    private void inicializarListenersBotonPasarTurno(Button boton) {
        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    setEstiloBoton("/botonPasarTurnoPresionado.png", boton, -8, 500, 75);
                    boton.setEffect(new DropShadow());
                });
        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    setEstiloBoton("/botonPasarTurnoSoltado.png", boton, -8, 500, 75);
                    boton.setEffect(null);
                });
        boton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    this.controladorJuego.avanzarTurno();
                });
    }

}


