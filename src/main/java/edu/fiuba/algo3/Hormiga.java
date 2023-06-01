package edu.fiuba.algo3;

public class Hormiga extends Enemigo {

    public Hormiga(Posicion posicion) {
        super(posicion);
        this.energia = 1;
    }

    public void morir(Jugador jugador, Contador muertesDeHormigas){
        muertesDeHormigas.aumentar();
        if (muertesDeHormigas.esIgual(11)){
            jugador.sumarCreditos(2);
        }else{
            jugador.sumarCreditos(1);
        }
    }
}
