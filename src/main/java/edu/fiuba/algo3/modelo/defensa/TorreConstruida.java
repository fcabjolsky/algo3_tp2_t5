package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Observable;

public class TorreConstruida extends Observable implements EstadoTorre{

    private Torre torre;

    public void setTorre(Torre torre) {
        this.torre = torre;
    }
    @Override
    public void defender(Enemigo enemigo) {
        this.notificarObservadores(this.torre.sistemaDeDefensa.obtenerNotificacionAObservadores(enemigo));
        this.torre.sistemaDeDefensa.defender(enemigo);
    }

    @Override
    public void avanzarTurno() {

    }
}
