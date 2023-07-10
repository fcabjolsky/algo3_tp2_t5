package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ControladorJuego implements Observador{

    private Partida partidaModelo;

    private Jugador jugadorModelo;
    private Logger logger;
    private Pane contenedor;
    private GridPane mapa;
    public ControladorJuego(String nombreDeJugador, Pane contenedor, GridPane mapa) {

        this.contenedor = contenedor;
        this.mapa = mapa;

        this.logger = new Logger();

        this.jugadorModelo = new Jugador(nombreDeJugador);
        Mapa mapaModelo = new CreadorMapaJson("src/main/java/edu/fiuba/algo3/modelo/mapa.json").crearMapa();
        Turno turnoModelo = new Turno(this.jugadorModelo, mapaModelo);
        this.partidaModelo = new Partida(mapaModelo, this.jugadorModelo, turnoModelo);

        agregarObservadoresMapa(mapaModelo);
        agregarLogger(jugadorModelo);
        agregarLogger(turnoModelo);
        agregarObservadoresPartida();


    }
    public void agregarObservadoresPartida(){
        agregarLogger(this.partidaModelo);
        this.partidaModelo.agregarObservador(this);
    }
    public void agregarObservadoresMapa(Mapa mapa){
        agregarLogger(mapa);
        mapa.agregarObservador(this);
    }
    public void agregarLogger(Observable observable){
        observable.agregarObservador(this.logger);
    }
    public void agregarObservadoresJugador(Observador observadorCreditos, Observador observadorDanio){
        this.jugadorModelo.agregarObservadores(observadorCreditos, observadorDanio);
    }

    public void agregarDefensaAPartida(Defensa defensa, CreditosView creditosJugador){
        try{
            agregarLogger((Torre)defensa);
            jugadorModelo.construirDefensa(defensa);
            creditosJugador.perderCreditos(defensa.getCosto());
        } catch (NoDisponeDeSuficientesCreditos e) {
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    public void avanzarTurno(){
        this.partidaModelo.avanzarTurno();
    }

    @Override
    public void actualizar(Observable observable, Object argument) {
        if(argument instanceof Hormiga){
            EnemigoView enemigo =new HormigaView(1,0);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
        if(argument instanceof Arania){
            EnemigoView enemigo =new AraniaView(1,0);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
        if(argument instanceof Topo){
            EnemigoView enemigo =new TopoView(1,0);
            ((Enemigo)(argument)).agregarObservador(enemigo);
            ((Enemigo)(argument)).agregarObservador(logger);
            contenedor.getChildren().add(enemigo);
        }
    }
}
