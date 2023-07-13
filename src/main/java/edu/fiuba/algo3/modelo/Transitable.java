package edu.fiuba.algo3.modelo;

public interface Transitable {
    public void recibirEnemigo(Enemigo enemigo);
    public void moverEnemigosA(Transitable otraParcela);

    public boolean contieneEnemigosVivos();

    int recolectarRecompensas();
}