package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    protected int energia;
    private Posicion posicion;

    public Enemigo(Posicion posicion) {
        this.posicion = posicion;
    }
    public void recibirDanio(int unDanio) {
        if (this.estaMuerta()) {
            throw new EnemigoMuerto();
        }
        this.energia -= unDanio;
    }

    public boolean estaMuerta() {
        return this.energia <= 0;
    }

    public boolean estaEnRango(Rango unRango) {
        return unRango.estaEnRango(this.posicion);
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    public void avanzar(Posicion posicion) {
        this.posicion = posicion;
    }
}
