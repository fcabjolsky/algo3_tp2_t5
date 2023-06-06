package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    protected int energia;
    protected Posicion posicion;
    protected int velocidad;

    protected int contadorAvance;

    public Enemigo(Posicion posicion) {
        this.posicion = posicion;
        this.contadorAvance = -1;
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
        this.contadorAvance++;
    }

    public boolean enMovimiento(){
        return (contadorAvance < velocidad);
    }


}
