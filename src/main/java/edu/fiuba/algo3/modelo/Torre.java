package edu.fiuba.algo3.modelo;


public class Torre implements Defensa{

    private EstadoTorre estado;

    public Torre (int tiempoDeConstruccion){
        estado = new TorreEnConstruccion(tiempoDeConstruccion);
    }
    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }

    public void defender(Enemigo enemigo){
        estado.defender(enemigo);
    }

}
