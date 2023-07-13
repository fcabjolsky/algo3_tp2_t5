package edu.fiuba.algo3.modelo;

public class Inmovilizado implements Movible {

    @Override
    public Movible moverA(Enemigo enemigo, Transitable otraPasarela) {
        return this;
    }

    @Override
    public boolean puedoSeguirMoviendome() {
        return false;
    }
}
