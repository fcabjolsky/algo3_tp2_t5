package edu.fiuba.algo3.modelo;

public class TorreEnConstruccion extends  Observable implements EstadoTorre {

    private int numeroDeTurno;
    private int tiempoDeConstruccion;

    public TorreEnConstruccion(int tiempoDeConstruccion){
        numeroDeTurno = 0;
        this.tiempoDeConstruccion= tiempoDeConstruccion;
    }

    @Override
    public void defender(Pasarela pasarela, int danio){
        this.notificarObservadores("me estoy construyendo");
    }

    @Override
    public EstadoTorre avanzarTurno() {
        numeroDeTurno++;
        if(numeroDeTurno >= tiempoDeConstruccion){
            this.notificarObservadores("Se termino de construir la torre");
            TorreConstruida torreConstruida = new TorreConstruida();
            torreConstruida.replicarObservadores(this);
            return torreConstruida;
        }else{
            return this;
        }
    }
}
