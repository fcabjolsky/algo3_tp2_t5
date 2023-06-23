package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    public Hormiga() {
        this.energia = 1;
        this.velocidad = 1;
        this.estado = new EnMovimiento(this.velocidad);
        this.danio = 1;
    }

    public void morir(Jugador jugador, Contador cantidadDehormigasMuertas){
        cantidadDehormigasMuertas.aumentar();
        if (cantidadDehormigasMuertas.esMayorA(10)){
            jugador.sumarCreditos(2);
        }else{
            jugador.sumarCreditos(1);
        }
    }
}
