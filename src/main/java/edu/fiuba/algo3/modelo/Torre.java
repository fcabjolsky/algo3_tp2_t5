package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoTorre;
import edu.fiuba.algo3.modelo.TorreEnConstruccion;

public abstract class Torre implements Defensa {

    protected Rango rango;
    protected int danio;

    private EstadoTorre estado;
    protected int costo;

    public Torre (int tiempoDeConstruccion, int costo){
        this.estado = new TorreEnConstruccion(tiempoDeConstruccion);
        this.costo = costo;
    }

    public int getCosto() {
        return this.costo;
    }

    @Override
    public void defender(Enemigo enemigo) {
        if(enemigo.estaEnRango(this.rango)) {
            estado.defender(enemigo, this.danio);

        }
        else {
            throw new EnemigoFueraDeRango();
        }
    }

    public boolean puedeConstruir(int creditos) {
        return (this.costo <= creditos);
    }


    public void avanzarTurno(){
        estado = estado.avanzarTurno();
    }


    public Posicion posicion() {
        return this.rango.posicion();
    }


}
