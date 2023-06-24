package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entidad extends JPanel implements Runnable {

    protected Posicion posicion;
    private Thread threadJuego;
    protected BufferedImage imagen;

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Entidad(Posicion posicion, int anchoTile, int altoTile){
        this.posicion = posicion;
        this.setPreferredSize(new Dimension(anchoTile, altoTile));
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        addMouseListener(new ControladorMouse(this));
        this.empezarThreadDeJuego();
    }
    public abstract Entidad devolverNuevaInstancia(Posicion posicion, int anchoTile, int altoTile);

    @Override
    public void paintComponent(Graphics grafico){
        super.paintComponent(grafico);
        Graphics2D grafico2D = (Graphics2D)grafico;
        grafico.drawImage(this.imagen, 0, 0,
                this.getWidth(), this.getHeight(), this);
    }
    private void empezarThreadDeJuego(){
        threadJuego = new Thread(this);
        threadJuego.start();
    }
    @Override
    public void run() {
        while (threadJuego != null){
            //1- actualizar informacion de mapa.
            this.actualizar();
            //2- dibujar la escena.
            this.repaint();
        }
    }

    public void actualizar(){
    }
}
