package edu.fiuba.algo3.modelo;

public interface Defensa {

    public Defensa construir(Jugador jugador);

    public void defender(Pasarela pasarela);

    public boolean puedeConstruir(int creditos);

    public void avanzarTurno();

    public int getCosto();

    public boolean estaEnRango(Posicion unaPosicion);

}
