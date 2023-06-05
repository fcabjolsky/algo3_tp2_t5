package edu.fiuba.algo3;

public abstract class Torre implements Defensa {

    protected Rango rango;
    protected int danio;

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
        return this.rango.posicion();
    }

}
