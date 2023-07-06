package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ElegirNombreViewController {

    @FXML
    private Button botonEmpezar;
    @FXML
    private Button botonSalir;
    @FXML
    private TextField textNombre;

    static String nombreDeJugador;

    public void cerrarVentana(){
        Stage stage = (Stage) this.botonSalir.getScene().getWindow();
        stage.close();
    }
    @FXML
    void botonSalirOnAction(ActionEvent event) {
        cerrarVentana();
    }
    @FXML
    void botonEmpezarOnAction(ActionEvent event) {
        if (textNombre.getText().trim().length() < 6){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("El nombre ingresado debe tener más de 6 caracteres");
            alerta.showAndWait();
        }else{
            nombreDeJugador = textNombre.getText();
            PartidaViewController controller = new PartidaViewController();
            Scene scene = controller.InicializarPartidaView("src/main/java/edu/fiuba/algo3/modelo/mapa.json");
            Stage partida = new Stage();
            partida.initStyle(StageStyle.UNDECORATED);
            partida.setScene(scene);
            partida.show();
            cerrarVentana();
        }
    }


}