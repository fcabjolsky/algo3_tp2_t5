package edu.fiuba.algo3;

public class Arania {
    private int energia = 2;
    public void recibirDanio(int unDanio) {
        if (this.estaMuerta()) {
            throw new AraniaMuerta();
        }
        this.energia -= unDanio;
    }

    public boolean estaMuerta() {
        return this.energia <= 0;
    }
}
