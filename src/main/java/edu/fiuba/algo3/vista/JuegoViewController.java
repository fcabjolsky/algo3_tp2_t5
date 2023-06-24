package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.Conexion;
import edu.fiuba.algo3.vista.PartidaViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class JuegoViewController extends Stage{

    @FXML
    private AnchorPane panel;

    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button botonCargarPartida;

    @FXML
    private Button botonIniciarPartida;

    @FXML
    private Button botonSalir;


    @FXML
    void botonCargarPartidaOnAction(javafx.event.ActionEvent event) {

    }
    @FXML
    void botonIniciarPartidaOnAction(javafx.event.ActionEvent event) {
        PartidaViewController partida = new PartidaViewController("src/main/java/edu/fiuba/algo3/modelo/mapa.json");
        partida.setLocationRelativeTo(null);
        partida.setVisible(true);
        cerrarVentana();
    }

    @FXML
    void botonSalirOnAction(ActionEvent event) {
        cerrarVentana();
    }

    public void cerrarVentana(){
        Stage stage = (Stage) this.botonSalir.getScene().getWindow();
        stage.close();
    }

    void setHoverEntradaBoton(Button boton){
        boton.setEffect(new DropShadow());
        boton.setEffect(new Lighting());
        boton.setStyle("    -fx-background-color: #0074FF;" +
                "    -fx-background-insets: 0,1,2;" +
                "    -fx-background-radius: 10;"+
                "    -fx-text-fill: black;");
    }

    void setHoverSalidaBoton(Button boton){
        boton.setEffect(null);
        boton.setStyle(
                "    -fx-background-color: #0074FF;" +
                        "    -fx-background-radius: 10;"+
                        "    -fx-text-fill: white;");
    }

    void setEstiloBotonPresionado(Button boton, MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)){
            boton.setEffect(new Lighting());
            boton.setStyle("    -fx-background-color: #0074FF;" +
                    "    -fx-background-insets: 0,1,2;" +
                    "    -fx-background-radius: 10;"+
                    "    -fx-text-fill: black;");
            boton.setLayoutY(boton.getLayoutY() - 4);
        }
    }
    void setEstiloBotonSoltado(Button boton, MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            boton.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-background-radius: 10;");
            boton.setLayoutY(boton.getLayoutY() + 4);
        }
    }

    @FXML
    void setOnMouseEnteredBotonIniciarPartida(MouseEvent event) {
        this.setHoverEntradaBoton(this.botonIniciarPartida);
    }

    @FXML
    void setOnMouseExitedBotonIniciarPartida(MouseEvent event) {
        this.setHoverSalidaBoton(this.botonIniciarPartida);
    }
    @FXML
    void setOnMousePressedBotonIniciarPartida(MouseEvent event) {
        this.setEstiloBotonPresionado(this.botonIniciarPartida, event);
    }

    @FXML
    void setOnMouseReleasedBotonIniciarPartida(MouseEvent event) {
        this.setEstiloBotonSoltado(this.botonIniciarPartida, event);
    }

    @FXML
    void setOnMouseEnteredBotonCargarPartida(MouseEvent event) {
        this.setHoverEntradaBoton(this.botonCargarPartida);
    }
    @FXML
    void setOnMouseExitedBotonCargarPartida(MouseEvent event) {
        this.setHoverSalidaBoton(this.botonCargarPartida);
    }

    @FXML
    void setOnMousePressedBotonCargarPartida(MouseEvent event) {
        this.setEstiloBotonPresionado(this.botonCargarPartida, event);
    }

    @FXML
    void setOnMouseReleasedBotonCargarPartida(MouseEvent event) {
        this.setEstiloBotonSoltado(this.botonCargarPartida, event);
    }

    @FXML
    void setOnMouseEnteredBotonSalir(MouseEvent event) {
        this.setHoverEntradaBoton(this.botonSalir);
    }

    @FXML
    void setOnMouseExitedBotonSalir(MouseEvent event) {
        this.setHoverSalidaBoton(this.botonSalir);
    }

    @FXML
    void setOnMousePressedBotonSalir(MouseEvent event) {
        this.setEstiloBotonPresionado(this.botonSalir, event);
    }

    @FXML
    void setOnMouseReleasedBotonSalir(MouseEvent event) {
        this.setEstiloBotonSoltado(this.botonSalir, event);
    }





    public LinkedList<Partida> obtenerTodasLasPartidas(){
        LinkedList<Partida> listaDePartidas = new LinkedList<>();
        String sql = "SELECT * FROM partida";
        try {
            edu.fiuba.algo3.vista.Conexion c = new Conexion();
            Connection conexion = c.getConexion();
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Mapa mapa = (Mapa)rs.getObject(1);
                Jugador jugador = (Jugador)rs.getObject(2);
                Partida partida = new Partida(mapa, jugador);
                listaDePartidas.add(partida);
            }
            conexion.close();
            stm.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al obtener la lista de Partidas");
        }
        return listaDePartidas;
    }

}
