package edu.fiuba.algo3.modelo;

public class TrampaArenosa extends Observable implements Defensa, Turneable{

    private final EstadoTrampa estado;
    private final int costo;
    private final int danio;
    private final float efecto;
    private final int tiempoDeConstruccion;

    public TrampaArenosa(int tiempoDeConstruccion, int costo, int danio){
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.estado = new TrampaActiva();
        this.costo = costo;
        this.danio = danio;
        this.efecto = 0.5F;
    }

    @Override
    public Defensa construir(Jugador jugador) {
        return null;
    }

    @Override
    public void defender(Enemigo enemigo) {

    }

    @Override
    public boolean puedeConstruir(int creditos) {
        return false;
    }

    @Override
    public void avanzarTurno() {

    }

    @Override
    public boolean estaEnRango(Posicion unaPosicion) {
        return false;
    }

    public void aplicarEfecto(Enemigo e){
        e.afectarVelocidadPorFactor(0.5F);
    }
}
