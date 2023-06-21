package edu.fiuba.algo3.modelo;

public class EnemigoInmovilizado implements EstadoEnemigo {


    @Override
    public void movermeA(Enemigo enemigo, Pasarela otraPasarela) {}

    @Override
    public boolean puedoSeguirMoviendome() {
        return false;
    }
}
