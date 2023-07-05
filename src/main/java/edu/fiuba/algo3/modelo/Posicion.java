package edu.fiuba.algo3.modelo;

public class Posicion {
    private int coordenadaX;

    private int coordenadaY;

    public int getCoordenadaX() {
       return this.coordenadaX;
    }

    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    public Posicion (int coordenadaX, int coordeandaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordeandaY;
    }

    public float calcularDistanciaA(Posicion otraPosicion) {
        float componenteX =(float)Math.pow(this.getCoordenadaX() - otraPosicion.getCoordenadaX(), 2);
        float componenteY =(float)Math.pow(this.getCoordenadaY() - otraPosicion.getCoordenadaY(), 2);
        return (float)Math.sqrt(componenteX + componenteY);
    }
}
