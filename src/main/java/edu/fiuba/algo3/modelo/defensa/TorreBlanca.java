package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.NoDisponeDeSuficientesCreditos;
import edu.fiuba.algo3.modelo.Posicion;

public class TorreBlanca extends Torre {


    public TorreBlanca(Posicion posicion) {
        super(1, 10, new SistemaDeDefensa(1,  new Rango(3, posicion)));
    }

    public Defensa construir(Jugador jugador) {
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
            this.empezarAConstruir();
            return this;
        }else{
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    @Override
    public String toString() {
        return "Torre Blanca";
    }

}
