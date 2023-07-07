package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
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

    public ControladorJuego(String nombreDeJugador, Pane contenedor, GridPane mapa, Observador observadorPartida) {
        this.jugador = new Jugador(nombreDeJugador);
        System.out.println(jugador);
        this.partida = new Partida(this.jugador, observadorPartida);
        this.contenedor = contenedor;
        this.mapa = mapa;
        this.enemigos = new ArrayList<>();
        this.defensas = new ArrayList<>();
    }

    public void agregarObservadoresJugador(Observador observadorCreditos, Observador observadorDanio){
        this.jugador.agregarObservadores(observadorCreditos, observadorDanio);
    }
    public void agregarDefensa(DefensaView defensa){
        this.defensas.add(defensa);
    }

    public void agregarDefensaAPartida(Defensa defensa, CreditosView creditosJugador){
        try{
            jugador.construirDefensa(defensa);
            creditosJugador.perderCreditos(defensa.getCosto());
        } catch (NoDisponeDeSuficientesCreditos e) {
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    public void avanzarTurno(){
        this.partida.avanzarTurno();
    }

}
