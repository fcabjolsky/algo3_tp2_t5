package edu.fiuba.algo3.modelo;

public abstract class Torre extends Observable implements Defensa, Turneable {
    protected Rango rango;
    protected int danio;
    protected EstadoTorre estado;
    protected int costo;
    protected final int tiempoDeConstruccion;


    public Torre (int tiempoDeConstruccion, int costo, int danio, Rango rango, Observador observador){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.nuevoEstado(new TorreEnConstruccion());
        this.costo = costo;
        this.danio = danio;
        this.rango = rango;
        this.agregarObservador(observador);
    }

    public Torre (int tiempoDeConstruccion, int costo, int danio, Rango rango){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.nuevoEstado(new TorreEnConstruccion());
        this.costo = costo;
        this.danio = danio;
        this.rango = rango;
    }

    protected void empezarAConstruir() {
        TorreEnConstruccion torreEnConstruccion = new TorreEnConstruccion();
        torreEnConstruccion.replicarObservadores(this);
        this.nuevoEstado(torreEnConstruccion);
    }

    public void nuevoEstado(EstadoTorre nuevoEstado) {
        this.estado = nuevoEstado;
        this.estado.setTorre(this);
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public void defender(Pasarela pasarela) {
        this.estado.defender(pasarela);
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }

    @Override
    public void avanzarTurno(){
        this.estado.avanzarTurno();
    }

    public boolean estaEnRango(Posicion unaPosicion) {
        return this.rango.estaEnRango(unaPosicion);
    }
}


