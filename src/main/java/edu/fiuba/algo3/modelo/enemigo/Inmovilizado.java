package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Transitable;

public class Inmovilizado implements Movible {

    @Override
    public Movible moverA(Enemigo enemigo, Transitable otraPasarela) {return this;}

    @Override
    public boolean puedoSeguirMoviendome() {
        return false;
    }
}
