package edu.fiuba.algo3.modelo;

public interface Defensa {
    
    public Defensa construir(Jugador jugador, Posicion posicion);

    public void defender(Enemigo enemigo);

    public boolean puedeConstruir(int creditos);

    public void avanzarTurno();

    public boolean estaEnRango(Posicion unaPosicion);

    public Posicion posicion();
}
