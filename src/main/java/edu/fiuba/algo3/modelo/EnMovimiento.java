package edu.fiuba.algo3.modelo;

public class EnMovimiento implements Movible {

    private int movimientosRestantes;

    public EnMovimiento(int velocidad) {
        this.movimientosRestantes = velocidad;
    }

    public boolean puedoSeguirMoviendome() {
        return this.movimientosRestantes > 0;
    }
    @Override
    public void moverA(Enemigo enemigo, Transitable transitable) {
        transitable.recibirEnemigo(enemigo);
        this.movimientosRestantes --;
    }


}
