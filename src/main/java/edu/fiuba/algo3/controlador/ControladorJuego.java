package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ControladorJuego {

    private Partida partida;

    private Jugador jugador;

    private ArrayList<DefensaView> defensas;
    private ArrayList<EnemigoView> enemigos;

    private Pane contenedor;

    private GridPane mapa;

    public ControladorJuego(String nombreDeJugador, Pane contenedor, GridPane mapa, Observador observador) {
        this.jugador = new Jugador(nombreDeJugador);
        System.out.println(jugador);
        this.partida = new Partida(this.jugador, observador);
        this.contenedor = contenedor;
        this.mapa = mapa;
        this.enemigos = new ArrayList<>();
        this.defensas = new ArrayList<>();
    }

    public void agregarDefensa(DefensaView defensa){
        this.defensas.add(defensa);
    }

    public void agregarDefensaAPartida(Defensa defensa){
        jugador.construirDefensa(defensa);
    }

    public void avanzarTurno(){
        this.partida.avanzarTurno();
    }

}
