package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.PanelDePartida;

import javax.swing.*;
import java.awt.*;

public class PartidaViewController extends JFrame{

    JPanel panelDePartida = new PanelDePartida();


    public PartidaViewController(){
        this.add(this.panelDePartida);
        this.setUndecorated(true);
        this.pack();
    }
}
