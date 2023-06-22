package edu.fiuba.algo3.modelo;

public class Inmovilizado implements Movible {

    @Override
    public void moverA(Enemigo enemigo, Transitable otraPasarela) {}

    @Override
    public boolean puedoSeguirMoviendome() {
        return false;
    }
}
