package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Jugador extends Observable implements Turneable{
    private int vida = 20;
    private int creditos = 100;
    private List <Defensa> defensas = new ArrayList();
    private String nombre;

    private int observadorDanio = 2;
    private int observadorCreditos = 1;


    public Jugador(String unNombre) {
        if (!this.validarNombre(unNombre)) {
            throw new NombreInvalido();
        }
    }

    public Jugador(int vida, int creditos, String unNombre) {
        this.vida = vida;
        this.creditos = creditos;
        if (!this.validarNombre(unNombre)) {
            throw new NombreInvalido();
        }
    }

    public void agregarObservadores(Observador observadorCreditos, Observador observadorDanio){
        this.agregarObservador(observadorCreditos);
        this.agregarObservador(observadorDanio);
    }

    private boolean validarNombre(String unNombre) {
        if (unNombre.trim().length() >= 6) {
            this.nombre = unNombre;
            return true;
        }
        return false;
    }

    public int getVida() {
        return vida;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public boolean puedeConstruir(int costo){
      return (costo <= this.creditos);
    }
    

    public void sumarCreditos(int creditos){
        this.notificarObservador(creditos, this.observadorCreditos);
        this.creditos += creditos;
    }

    public void restarCreditos(int creditos){
        this.creditos -= creditos;
    }

    public void perderVida(int danio){
        this.notificarObservador(danio, this.observadorDanio);
        this.vida -= danio;
        this.notificarObservadores("Jugador recibe danio: " + danio + ", vida restante: " + this.vida);
        if(this.vida <= 0){
            notificarObservadores("Perdiste");
        }
    }

    public boolean equals(Object jugador) {
        Jugador jugadorComparado = (Jugador)jugador;
        if (this.creditos == jugadorComparado.creditos && this.vida == jugadorComparado.vida){
            return true;
        }
        return false;
    }

    public boolean estaMuerto() {
       return this.vida <= 0;
    }

    public List<Defensa> obtenerDefensas() {
        return this.defensas;
    }

    public void construirDefensa(Defensa nuevaDefensa) {
        if (nuevaDefensa.puedeConstruir(this.creditos)) {
            this.notificarObservadores("Agregando defensa: " + nuevaDefensa.toString());
            nuevaDefensa.construir(this);
            defensas.add(nuevaDefensa);
        }
        else{
            throw new NoDisponeDeSuficientesCreditos();
        }
    }

    public void avanzarTurno() {
        for (Defensa defensa : this.defensas) {
            defensa.avanzarTurno();
        }
    }

    @Override
    public String toString(){
        return this.nombre;
    }

}
