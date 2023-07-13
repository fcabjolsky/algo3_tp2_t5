package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public class EstadoActivado implements EstadoSistemaDeDefensa {

    private SistemaDeDefensa sistemaDeDefensa;
    @Override
    public void setSistemaDeDefensa(SistemaDeDefensa sistemaDeDefensa) {
        this.sistemaDeDefensa = sistemaDeDefensa;
    }

    @Override
    public void defender(Enemigo enemigo, int danio) {
        enemigo.recibirDanio(danio);
        this.sistemaDeDefensa.nuevoEstado(new EstadoDesactivado());
    }

    @Override
    public void avanzarTurno() {}
}
