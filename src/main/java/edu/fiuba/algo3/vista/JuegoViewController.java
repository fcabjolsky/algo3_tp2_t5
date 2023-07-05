package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class JuegoViewController extends Stage{

    @FXML
    private AnchorPane panel;

    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button botonIniciarPartida;

    @FXML
    private Button botonSalir;

    @FXML
    void botonIniciarPartidaOnAction(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ElegirNombreView.fxml"));
            Stage juegoStage = new Stage();
            juegoStage.initStyle(StageStyle.UNDECORATED);
            juegoStage.setScene(new Scene(root, PartidaViewController.anchoDePantalla, PartidaViewController.altoDePantalla));
            juegoStage.show();
            cerrarVentana();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

}
