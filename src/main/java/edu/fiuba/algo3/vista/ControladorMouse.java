package edu.fiuba.algo3.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorMouse extends MouseAdapter {

    private Entidad parcela;

    ControladorMouse(Entidad parcela){
        this.parcela = parcela;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("x= "+ parcela.getX()+"y="+parcela.getY());
    }
}
