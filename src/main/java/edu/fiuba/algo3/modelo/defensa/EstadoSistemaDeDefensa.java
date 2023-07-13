package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public interface EstadoSistemaDeDefensa extends Turneable {
    void setSistemaDeDefensa(SistemaDeDefensa sistemaDeDefensa);

    void defender(Enemigo enemigo, int danio);
}
