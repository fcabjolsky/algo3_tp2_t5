package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {


    public TorreBlanca(Posicion posicion) {
        super(1, 10);
        this.rango = new Rango(3, posicion);
    }

    public TorreBlanca() {
        super(1, 10);
    }

    public Defensa construir(Jugador jugador, Posicion posicion) {
        TorreBlanca torreADevolver = new TorreBlanca(posicion);
        if (jugador.puedeConstruir(super.costo)){
            jugador.restarCreditos(super.costo);
             return (new TorreBlanca(posicion));
        }else{
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

}
