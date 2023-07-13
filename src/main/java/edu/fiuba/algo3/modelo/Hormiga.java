package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {

    private ContadorDeMuertesDeHormiga contadorDeMuertesDeHormiga;
    public Hormiga() {
        super();
        this.energia = 1;
        this.velocidad = 1;
        this.estado = new EnMovimiento(this.velocidad);
        this.ataqueEnemigo = new AtaqueEnemigoNormal();
        this.danio = 1;
        this.contadorDeMuertesDeHormiga = ContadorDeMuertesDeHormiga.obtenerContador();
    }

    public void morir(Jugador jugador){
        this.contadorDeMuertesDeHormiga.incrementar();
        if (this.contadorDeMuertesDeHormiga.esMayorA(10)){
            jugador.sumarCreditos(2);
        }else{
            jugador.sumarCreditos(1);
        }
    }

    @Override
    public int darRecompensa() {
        int recompensa;
        this.contadorDeMuertesDeHormiga.incrementar();
        if (this.contadorDeMuertesDeHormiga.esMayorA(10)) {
            recompensa = 2;
        }else{
            recompensa = 1;
        }
        this.notificarObservadores("Jugador recibe " + recompensa + " creditos");
        return recompensa;
    }

    @Override
    public String toString() {
        return "Hormiga";
    }
}
