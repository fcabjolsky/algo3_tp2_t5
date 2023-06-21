package edu.fiuba.algo3.modelo;

public class EnemigoEnMovimiento implements EstadoEnemigo{

    private int movimientosRestantes;

    public EnemigoEnMovimiento(int velocidad) {
        this.movimientosRestantes = velocidad;
    }

    public boolean puedoSeguirMoviendome() {
        return this.movimientosRestantes > 0;
    }
    @Override
    public void movermeA(Enemigo enemigoEnMovimiento, Pasarela otraPasarela) {
        otraPasarela.agregarEnemigo(enemigoEnMovimiento);
        this.movimientosRestantes --;
    }


}
