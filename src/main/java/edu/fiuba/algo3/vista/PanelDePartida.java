package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class PanelDePartida extends JPanel implements Runnable{

    final int maximoDeColumnas = 15;
    final int maximoDeFilas = 15;
    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    final int tamanioDelTileAncho = (anchoDePantalla/maximoDeColumnas) - 5;
    final int tamanioDelTileAlto = (altoDePantalla/maximoDeFilas);
    private Thread threadJuego;
    private TileManager paisaje;
    public PanelDePartida(){
        String url = "src/main/java/edu/fiuba/algo3/modelo/mapa.json";
        this.paisaje = new TileManager(this, url);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(this.anchoDePantalla, this.altoDePantalla));
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.empezarThreadDeJuego();
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
    @Override
    public void paintComponent(Graphics grafico){
        super.paintComponent(grafico);
        Graphics2D grafico2D = (Graphics2D)grafico;
        paisaje.draw(grafico2D);
    }
}
