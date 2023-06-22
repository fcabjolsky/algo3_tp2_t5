package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.PanelDePartida;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import edu.fiuba.algo3.vista.PanelDePartida;
public class App extends Application {

    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/EntradaView.fxml"));
            stage.setScene(new Scene(root, App.anchoDePantalla, App.altoDePantalla));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}