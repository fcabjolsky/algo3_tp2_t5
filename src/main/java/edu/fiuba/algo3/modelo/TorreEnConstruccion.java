package edu.fiuba.algo3.modelo;

public class TorreEnConstruccion extends  Observable implements EstadoTorre {

    private Contador contador;
    private Torre torre;

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    public TorreEnConstruccion(){
        this.contador = new Contador();
    }

    @Override
    public void defender(Pasarela pasarela){}

    @Override
    public void avanzarTurno() {
        contador.incrementar();
        if(!(contador.esMenorA(this.torre.tiempoDeConstruccion))){
            this.notificarObservadores("Se termino de construir la torre");
            TorreConstruida torreConstruida = new TorreConstruida();
            torreConstruida.replicarObservadores(this);
            this.torre.nuevoEstado(torreConstruida);;
        }
    }
}
