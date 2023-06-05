package edu.fiuba.algo3;

public interface Defensa {
    
    public Defensa construir(Jugador jugador, Posicion posicion);

    public void defender(Enemigo enemigo);

    public boolean puedeConstruir(int creditos);

    public Posicion posicion();
}
