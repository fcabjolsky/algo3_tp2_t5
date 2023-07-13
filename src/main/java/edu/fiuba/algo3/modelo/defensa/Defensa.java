package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Posicion;

public interface Defensa {

    public Defensa construir(Jugador jugador);

    public void defender(Enemigo enemigo);

    public boolean puedeConstruir(int creditos);

    public void avanzarTurno();

    public boolean estaEnRango(Posicion unaPosicion);

}
