package edu.fiuba.algo3.modelo;

public abstract class Torre extends Observable implements Defensa, Turneable {
    protected Rango rango;
    protected int danio;
    protected EstadoTorre estado;
    protected int costo;
    private final int tiempoDeConstruccion;

    public Torre (int tiempoDeConstruccion, int costo, int danio){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.estado = new TorreEnConstruccion(tiempoDeConstruccion);
        this.costo = costo;
        this.danio = danio;
    }

    public Torre (int tiempoDeConstruccion, int costo, int danio, Observador observador){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.estado = new TorreEnConstruccion(tiempoDeConstruccion);
        this.costo = costo;
        this.danio = danio;
        this.agregarObservador(observador);
    }

    protected void empezarAConstruir() {
        TorreEnConstruccion torreEnConstruccion = new TorreEnConstruccion(tiempoDeConstruccion);
        torreEnConstruccion.replicarObservadores(this);
        this.estado = torreEnConstruccion;
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public void defender(Pasarela pasarela) {
        this.estado.defender(pasarela, this.danio);
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }

    @Override
    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }

    public boolean estaEnRango(Posicion unaPosicion) {
        return this.rango.estaEnRango(unaPosicion); //esto podria pasar a ser responsabilidad de la defensa directamente
    }
}


