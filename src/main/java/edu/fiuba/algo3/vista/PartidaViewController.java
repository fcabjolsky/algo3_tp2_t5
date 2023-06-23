package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.PanelDePartida;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PartidaViewController extends JFrame{

    JPanel panelDePartida = new PanelDePartida();

    public PartidaViewController(){

        int anchoDeBoton = 75;
        int altoDeBoton = 75;
        JButton botonAgregarTorreBlanca = new JButton();
        JButton botonAgregarTorrePlateada = new JButton();
        JButton botonAgregarTrampaArena = new JButton();
        JButton botonSalirYGuardar = new JButton();

        this.setStyleButton("/botonSalirSoltado.png", botonSalirYGuardar, anchoDeBoton, 30, 720, 0);
        this.setStyleButton("/botonTorreBlanca.png", botonAgregarTorreBlanca, anchoDeBoton, altoDeBoton, 720, 40);
        this.setStyleButton("/botonTorrePlateada.png", botonAgregarTorrePlateada, anchoDeBoton, altoDeBoton, 720, 125);
        this.setStyleButton("/botonTrampaArena.png", botonAgregarTrampaArena, anchoDeBoton, altoDeBoton, 720, 210);

        panelDePartida.add(botonSalirYGuardar);
        panelDePartida.add(botonSalirYGuardar);
        panelDePartida.add(botonAgregarTorreBlanca);
        panelDePartida.add(botonAgregarTorrePlateada);
        panelDePartida.add(botonAgregarTrampaArena);

        this.add(this.panelDePartida);
        this.setUndecorated(true);
        this.pack();
        inicializarListenersSalir(botonSalirYGuardar);
    }

    public void setStyleButton(String url, JButton boton, int ancho, int alto, int x, int y ){
        ImageIcon fondo = new ImageIcon((new ImageIcon(getClass().getResource(url))).getImage().getScaledInstance(ancho, alto , Image.SCALE_SMOOTH));
        boton.setBounds(x, y, ancho, alto);
        boton.setIcon(fondo);
        boton.setBorderPainted(false);
        boton.setBackground(new Color(0,0,0,10));

    }

    void inicializarListenersSalir(JButton boton){
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                boton.setLocation(boton.getX(), boton.getY() - 5);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                boton.setLocation(boton.getX(), boton.getY() + 5);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e){
                setStyleButton("/botonSalirSoltado.png",boton, 75, 30, 720, 0);
            }
        });
    }



}
