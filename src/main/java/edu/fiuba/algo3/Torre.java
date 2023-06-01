package edu.fiuba.algo3;

public abstract class Torre implements Defensa {

    protected Rango rango;
    protected int danio;

    private  Posicion posicion;

    public Torre(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void defender(Enemigo enemigo) {
        if(enemigo.estaEnRango(this.rango)) {
            enemigo.recibirDanio(this.danio);
        }
        else {
            throw new EnemigoFueraDeRango();
        }
    }

    public Posicion posicion() {
        return this.posicion;
    }
}
