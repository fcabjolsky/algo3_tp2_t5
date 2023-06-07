package edu.fiuba.algo3.modelo;

public interface Defensa {
    
    public Defensa construir(Jugador jugador, Posicion posicion);

    public void defender(Mapa mapa);

    public boolean puedeConstruir(int creditos);

    public void avanzarTurno();
    public Posicion posicion();
}
