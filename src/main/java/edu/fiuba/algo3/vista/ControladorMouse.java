package edu.fiuba.algo3.vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
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

    @Override
    public void mouseEntered(MouseEvent e) {
        this.parcela.setBorder(new LineBorder(Color.CYAN));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.parcela.setBorder(BorderFactory.createEmptyBorder());
    }
}
