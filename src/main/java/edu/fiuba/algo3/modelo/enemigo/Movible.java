package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Transitable;

public interface Movible {

   public Movible moverA(Enemigo enemigo, Transitable transitable);

   public boolean puedoSeguirMoviendome();

}
