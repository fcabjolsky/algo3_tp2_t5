package edu.fiuba.algo3.vista;


import javax.swing.*;
import java.awt.*;

public class PartidaViewController extends JFrame {
    final static int anchoDePantalla = 795;
    final static int altoDePantalla = 600;
    final int maximoDeColumnas = 15;
    final int maximoDeFilas = 15;
    final int tamanioDelTileAncho = (anchoDePantalla/maximoDeColumnas) - 5;
    final int tamanioDelTileAlto = (altoDePantalla/maximoDeFilas);

    private JPanel panelBotones;
    private JPanel mapa;

    private ParcelaManager paisaje;

    JButton botonAgregarTorreBlanca;
    JButton botonAgregarTorrePlateada;
    JButton botonAgregarTrampaArena;
    JButton botonSalirYGuardar;

    public PartidaViewController(String urlInformacionDeMapa){
        int anchoDeBoton = 75;
        int altoDeBoton = 75;

        this.setPreferredSize(new Dimension(this.anchoDePantalla, this.altoDePantalla));
        this.setLayout(null);

        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(null);
        this.panelBotones.setBounds(720, 0, 75, altoDePantalla);
        this.panelBotones.setBackground(Color.BLACK);

        this.mapa = new JPanel(new GridLayout(this.maximoDeFilas, this.maximoDeColumnas));
        this.inicializarContenedorDeMapa(urlInformacionDeMapa);

        this.botonSalirYGuardar = setStyleButton("/botonSalirSoltado.png",anchoDeBoton, 30,0,0);
        this.botonAgregarTorreBlanca = setStyleButton("/botonTorreBlanca.png",anchoDeBoton, altoDeBoton,0,40);
        this.botonAgregarTorrePlateada = setStyleButton("/botonTorreBlanca.png",anchoDeBoton, altoDeBoton,0, 125);
        this.botonAgregarTrampaArena = setStyleButton("/botonTorreBlanca.png",anchoDeBoton, altoDeBoton,0, 210);

        this.panelBotones.add(botonAgregarTorreBlanca);
        this.panelBotones.add(botonSalirYGuardar);
        this.panelBotones.add(botonAgregarTorrePlateada);
        this.panelBotones.add(botonAgregarTrampaArena);

        this.add(this.panelBotones);
        this.add(this.mapa);
        this.setUndecorated(true);
        this.pack();
    }

    private void inicializarContenedorDeMapa(String urlInformacionDeMapa){
        this.mapa.setBounds(0, 0, anchoDePantalla - 75 , altoDePantalla);
        this.paisaje = new ParcelaManager(this.mapa, urlInformacionDeMapa, this.maximoDeColumnas, this.maximoDeFilas);
        this.paisaje.inicializarPaisaje(this.mapa,this.tamanioDelTileAlto, this.tamanioDelTileAncho);
    }

    public JButton setStyleButton(String url, int ancho, int alto, int x, int y ){
        JButton boton = new JButton();
        Icon fondo = new ImageIcon(new ImageIcon(getClass().getResource(url)).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        boton.setBounds(x, y, ancho, alto);
        boton.setIcon(fondo);
        boton.setBackground(new Color(0,0,0,10));
        return boton;
    }

}
