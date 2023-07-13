package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Transitable;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public interface EstadoEnemigo {

    public void setEnemigo(Enemigo enemigo);

    public void recibirDanio(int unDanio);

    public void avanzar(Transitable siguienteTransitable);

    public int atacar();

    public int morir();

    boolean estaMuerto();
}
