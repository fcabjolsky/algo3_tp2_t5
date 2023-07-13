package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public class EstadoDesactivado implements EstadoSistemaDeDefensa {

    private SistemaDeDefensa sistemaDeDefensa;
    @Override
    public void setSistemaDeDefensa(SistemaDeDefensa sistemaDeDefensa) {
        this.sistemaDeDefensa = sistemaDeDefensa;
    }

    @Override
    public void defender(Enemigo enemigo, int danio) {}

    @Override
    public void avanzarTurno() {
        this.sistemaDeDefensa.nuevoEstado(new EstadoActivado());
    }
}
