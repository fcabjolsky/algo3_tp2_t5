package edu.fiuba.algo3.modelo;

public class AtaqueEnemigoSegunParidadDeTurno implements AtaqueEnemigo {

    private boolean TurnoEsPar() {
        return ((ContadorDeTurno.obtenerContador().obtenerValor() % 2) == 0);
    }

    @Override
    public int atacar(int unDanio) {
        if(this.TurnoEsPar()){
            return unDanio;
        }
        return (unDanio + 3);
    }
}
