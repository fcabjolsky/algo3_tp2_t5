package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;

import java.awt.*;

public abstract class Entidad {

    protected Posicion posicion;

    public abstract void draw(Graphics2D grafico, PanelDePartida panelDePartida);

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
