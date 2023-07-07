package edu.fiuba.algo3.vista;

import javafx.scene.control.Alert;

public class AlertaView {

    Alert alerta;
    public AlertaView() {
        this.alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
    }

    public void lanzarAlerta(String contenido){
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
