package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {


    public TorreBlanca(Posicion posicion) {
        super(1, 10, 1);
        this.rango = new Rango(3, posicion);
    }

    public TorreBlanca() {
        super(1, 10, 1);
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
