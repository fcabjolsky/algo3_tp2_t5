package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    public Hormiga(Posicion posicion) {
        super(posicion);
        this.energia = 1;
    }

    public void morir(Jugador jugador, Contador cantidadDehormigasMuertas){
        cantidadDehormigasMuertas.aumentar();
        if (cantidadDehormigasMuertas.esIgual(11)){
            jugador.sumarCreditos(2);
        }else{
            jugador.sumarCreditos(1);
        }
    }
}
