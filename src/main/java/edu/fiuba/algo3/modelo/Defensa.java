package edu.fiuba.algo3.modelo;

public interface Defensa extends Turneable{

    public Defensa construir(Jugador jugador);

    public void defender(Pasarela pasarela);

    public boolean puedeConstruir(int creditos);

    public int getCosto();

    public boolean estaEnRango(Posicion unaPosicion);


}
