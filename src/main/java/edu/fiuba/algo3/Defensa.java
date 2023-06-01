
package edu.fiuba.algo3;

public interface Defensa {
    
    public Defensa construir(Jugador jugador, Posicion posicion);
    public boolean puedeConstruir(int creditos);
}
