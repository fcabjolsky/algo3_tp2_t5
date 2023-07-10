package edu.fiuba.algo3.vista;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class ParcelaView extends Rectangle{

    protected Image imagen;
    protected Boolean ocupada;
    public ParcelaView(int anchoTile, int altoTile, int x, int y){
        this.setWidth(anchoTile);
        this.setHeight(altoTile);
        this.setX(x);
        this.setY(y);
        this.ocupada = false;
        inicializarListeners();
    }
    public abstract ParcelaView devolverNuevaInstancia(int anchoTile, int altoTile, int x, int y);
    public void asignarParcelaElegida(){
        PartidaViewController.parcelaElegida = this;
    }

    public void inicializarListeners(){
        this.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    DropShadow efecto = new DropShadow();
                    efecto.setColor(Color.AQUA);
                    setEffect(efecto);
        });
        this.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    setEffect(null);
                });
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    if (this instanceof TierraView){
                        asignarParcelaElegida();
                    }
                    else{
                        AlertaView parcelaInvalida = new AlertaView();
                        parcelaInvalida.lanzarAlerta("No se puede construir en la parcela elegida");
                    }
                });
    }
}
