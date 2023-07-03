package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo{
    Contador cantidadMovimientos;
    private ContadorDeTurno contadorDeTurno;
    public Topo(){
        super();
        this.cantidadMovimientos = new Contador();
        this.velocidad = 1;
        this.estado = new EnMovimiento(this.velocidad);
        this.danio = 2;
        this.energia = 1;
        this.contadorDeTurno = ContadorDeTurno.obtenerContador();
    }

    private boolean esPar() {
        return (this.contadorDeTurno.obtenerValor() % 2) == 0;
    }

    @Override
    public void recibirDanio(int unDanio) {
    }

    @Override
    public void morir(Jugador jugador) {
    }

    @Override
    public int darRecompensa() {
        return 0;
    }

    @Override
    public int atacar(){
        if(this.esPar()){
            return this.danio;
        }
        return 5;
    }

    @Override
    public void avanzar(Transitable siguienteTransitable){
        this.estado = this.estado.moverA(this, siguienteTransitable);
        this.cantidadMovimientos.incrementar();
        if(this.cantidadMovimientos.esMayorA(5)  && this.cantidadMovimientos.esMenorA(11)) {
            this.velocidad = 2;
        }
        if(this.cantidadMovimientos.esMayorA(11)){
            this.velocidad = 3;
        }
    }

}
