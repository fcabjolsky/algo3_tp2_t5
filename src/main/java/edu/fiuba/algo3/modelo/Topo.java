package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo{
    Contador cantidadMovimientos;
    public Topo(){
        this.cantidadMovimientos = new Contador();
        this.velocidad = 1;
        this.estado = new EnMovimiento(this.velocidad);
        this.danio = 2;
    }

    @Override
    public void morir(Jugador jugador, Contador cantidadDeMuertes) {
    }

    @Override
    public int atacar(){
        /*necesita conocer el contador del turno*/
    return 0;}

    @Override
    public void recibirDanio(int unDanio){}

    @Override
    public void avanzar(Transitable siguienteTransitable){
        /*actualizar su velocidad si el contador esta en 5 -> 2y en 11 -> 3*/
    }
}
