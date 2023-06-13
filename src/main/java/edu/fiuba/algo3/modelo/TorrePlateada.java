package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre{

    public TorrePlateada (Posicion posicion){
        super(2, 20, 2);
        this.rango = new Rango(5, posicion);
    }

    public TorrePlateada() {
        super(2, 20, 2);
    }

    public Defensa construir(Jugador jugador, Posicion posicion) {
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
            return (new TorrePlateada(posicion));
        }
        throw new NoDisponeDeSuficientesCreditos();
    }
}
