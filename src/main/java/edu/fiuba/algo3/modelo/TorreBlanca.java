package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {


    public TorreBlanca(Posicion posicion) {
        super(1, 10);
        this.rango = new Rango(3, posicion);
    }

    public TorreBlanca(int tiempoDeConstruccion, int costo) {
        super(tiempoDeConstruccion, costo);
    }

    public Defensa construir(Jugador jugador, Posicion posicion) {
        TorreBlanca torreADevolver = new TorreBlanca(posicion);
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
             torreADevolver = new TorreBlanca(posicion);
        }
        return torreADevolver;
    }

}
