package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;

public interface Transitable {
    public void recibirEnemigo(Enemigo enemigo);//deberia llamarse recibir movible pero la lista que guarda las clases que implementan transitable son de Enemigos no de Movibles

    public void moverEnemigosA(Transitable otraParcela);

    public boolean contieneEnemigosVivos();

    int recolectarRecompensas();
}