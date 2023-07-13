package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.NoDisponeDeSuficientesCreditos;
import edu.fiuba.algo3.modelo.Posicion;

public class TorrePlateada extends Torre {

    public TorrePlateada (Posicion posicion){
        super(2, 20, new SistemaDeDefensa(2,  new Rango(5, posicion)));
    }


    public Defensa construir(Jugador jugador) {
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
            this.empezarAConstruir();
            return this;
        }
        throw new NoDisponeDeSuficientesCreditos();
    }

    @Override
    public String toString() {
        return "Torre Plateada";
    }
}
