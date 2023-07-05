package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import java.io.IOException;

public class EntradaViewController extends Stage{

    @FXML
    private Button botonJugar;

    @FXML
    private ImageView imagenEntrada;

    @FXML
    private AnchorPane panel;

    @FXML
    void botonJugarOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/JuegoView.fxml"));
            Stage juegoStage = new Stage();
            juegoStage.initStyle(StageStyle.UNDECORATED);
            juegoStage.setScene(new Scene(root, PartidaViewController.anchoDePantalla, PartidaViewController.altoDePantalla));
            juegoStage.show();
            Stage stage = (Stage) this.botonJugar.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void setOnMouseEnteredBotonJugar(MouseEvent event) {
        botonJugar.setEffect(new DropShadow());
        botonJugar.setEffect(new Lighting());
        botonJugar.setStyle("    -fx-background-color: #43E30B;" +
                "    -fx-background-insets: 0,1,2;" +
                "    -fx-background-radius: 10;");
    }

    @FXML
    void setOnMouseExitedBotonJugar(MouseEvent event) {
        botonJugar.setEffect(null);
        botonJugar.setStyle(
                "-fx-background-color: #3CE128;" +
                        "-fx-background-radius: 10;");
    }

    @FXML
    void setOnMousePressedBotonJugar(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)){
            botonJugar.setEffect(new Lighting());
            botonJugar.setStyle(
                    "-fx-background-color: #43E30B;" +
                            "-fx-background-radius: 10;");
            botonJugar.setLayoutY(botonJugar.getLayoutY() - 4);
        }
    }

    @FXML
    void setOnMouseReleasedBotonJugar(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            botonJugar.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-background-radius: 10;");
            botonJugar.setLayoutY(botonJugar.getLayoutY() + 4);
        }
    }


}
