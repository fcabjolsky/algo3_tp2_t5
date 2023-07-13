package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.Turneable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public interface EstadoTorre extends Turneable {

    void defender(Enemigo enemigo);

    public void setTorre(Torre torre);
}
