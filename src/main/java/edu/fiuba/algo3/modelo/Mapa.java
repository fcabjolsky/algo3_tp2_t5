package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
    private Enemigo enemigo1;
    private List<Pasarela> pasarelas;
    private List<Rocoso> rocosos;
    private List<Tierra> tierras;

    public Mapa(List<Pasarela> pasarelas, List<Rocoso> rocosos, List<Tierra> tierras) {
        this.pasarelas = pasarelas;
        this.rocosos = rocosos;
        this.tierras = tierras;
    }

    public void agregarEnemigo(Enemigo enemigo1) {
        enemigo1.avanzar(this.obtenerPosicionPasarelaInicial());
        this.enemigo1 = enemigo1;
    }

    private Posicion obtenerPosicionPasarelaInicial() {
        return this.pasarelas.get(0).getPosicion();
    }

    public void pasarTurno() {
        this.enemigo1.avanzar(new Posicion(0, 1));
    }
}
