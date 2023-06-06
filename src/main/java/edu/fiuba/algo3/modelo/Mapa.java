package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Posicion;

public class Mapa {
    private Enemigo enemigo1;

    public void agregarParcela(Pasarela pasarela) {
    }

    public void agregarEnemigo(Enemigo enemigo1) {
        this.enemigo1 = enemigo1;
    }

    public Posicion obtenerPoscionInicial() {
        return new Posicion(0, 0);
    }

    public void pasarTurno() {
        this.enemigo1.avanzar(new Posicion(0, 1));
    }
}
