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
        this.estado.moverA(this, siguienteTransitable);
        if(!this.estado.puedoSeguirMoviendome()) {
            this.estado = new Inmovilizado();
            return;
        }
        this.cantidadMovimientos.aumentar();
        if(this.cantidadMovimientos.esMayorA(5)  && this.cantidadMovimientos.esMenorA(11)) {
            this.velocidad = 2;
        }
        if(this.cantidadMovimientos.esMayorA(11)){
            this.velocidad = 3;

        }
    }
}
