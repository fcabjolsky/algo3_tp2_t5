package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJuego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PantallaGanasteViewController {
    @FXML
    private Button botonSalir;
    @FXML
    private Text textoNombre;


    @FXML
    public void initialize(){
        textoNombre.setText(ElegirNombreViewController.nombreDeJugador);
    }

    @FXML
    void botonSalirOnAction(ActionEvent event) {
        Stage cerrar = (Stage)this.botonSalir.getScene().getWindow();
        cerrar.close();
    }

    @FXML
    void botonSalirOnMouseEntered(MouseEvent event) {
        botonSalir.setEffect(new DropShadow());
        botonSalir.setEffect(new Lighting());
        botonSalir.setStyle("    -fx-background-color: #F90000;" +
                "    -fx-background-insets: 0,1,2;" +
                "    -fx-background-radius: 15;"+
                "    -fx-text-fill: white;");
    }
    @FXML
    void botonSalirOnMouseExited(MouseEvent event) {
        botonSalir.setEffect(null);
        botonSalir.setStyle("    -fx-background-color: #F90000;" +
                "    -fx-background-radius: 15;"+
                "    -fx-text-fill: white;");
    }

}

