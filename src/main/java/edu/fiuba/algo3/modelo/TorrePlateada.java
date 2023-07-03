package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre{

    public TorrePlateada (Posicion posicion){
        super(2, 20, 2);
        this.rango = new Rango(5, posicion);
    }

    public TorrePlateada() {
        super(2, 20, 2);
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
