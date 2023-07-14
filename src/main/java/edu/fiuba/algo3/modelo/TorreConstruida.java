package edu.fiuba.algo3.modelo;

public class TorreConstruida extends Observable implements EstadoTorre {

    private Torre torre;

    public void setTorre(Torre torre) {
        this.torre = torre;
    }
    @Override
    public void defender(Pasarela pasarela) {
        this.notificarObservadores("Torre ataca a enemigo en posicion " + pasarela.getPosicion().toString());
        this.notificarObservadores(pasarela);
        pasarela.obtenerEnemigoADaniar().recibirDanio(this.torre.danio);
    }

    @Override
    public void avanzarTurno() {}
}
