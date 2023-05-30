package edu.fiuba.algo3;

public class Hormiga {
    private int energia = 1;
    public void recibirDanio(int unDanio) {
        if (this.estaMuerta()) {
            throw new HormigaMuerta();
        }
        this.energia -= unDanio;
    }

    public boolean estaMuerta() {
        return this.energia <= 0;
    }
}
