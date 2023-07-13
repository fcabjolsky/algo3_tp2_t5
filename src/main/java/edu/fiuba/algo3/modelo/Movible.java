package edu.fiuba.algo3.modelo;

public interface Movible {

   Movible moverA(Enemigo enemigo, Transitable transitable);

   boolean puedoSeguirMoviendome();

}
