package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.Jugador;

public class Hormiga extends Enemigo {

    private ContadorDeMuertesDeHormiga contadorDeMuertesDeHormiga;
    public Hormiga() {
        super(1, 1,1 , new AtaqueEnemigoNormal());
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
        this.contadorDeMuertesDeHormiga.incrementar();
        if (this.contadorDeMuertesDeHormiga.esMayorA(10)) {
            return 2;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Hormiga";
    }
}
