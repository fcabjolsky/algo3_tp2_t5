package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre{

    public TorrePlateada (Posicion posicion){
        super(2, 20);
        this.rango = new Rango(5, posicion);
    }

    public TorrePlateada(int tiempoDeConstruccion, int costo) {
        super(tiempoDeConstruccion, costo);
    }

    public Defensa construir(Jugador jugador, Posicion posicion) {
        TorrePlateada torreADevolver = new TorrePlateada(posicion);
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
            torreADevolver = new TorrePlateada(posicion);
        }
        return torreADevolver;
    }
}
