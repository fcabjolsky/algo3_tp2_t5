package edu.fiuba.algo3;
import java.util.ArrayList;
import java.util.List;

public class Partida {


    private List<Enemigo> enemigosAtacables;

    private Mapa mapa;


    public Partida(Mapa mapa, List<Enemigo> enemigos) {
        this.mapa = mapa;
        this.enemigosAtacables = enemigos;
    }


    public void siguienteTurno() {
        List<Enemigo> nuevosEnemigos =  this.mapa.obtenerEnemigosSiguienteTurno();
        if(nuevosEnemigos.isEmpty() && this.enemigosAtacables.isEmpty()) {
            throw new JuegoGanado();
        }
    }

}
