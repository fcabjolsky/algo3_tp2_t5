package edu.fiuba.algo3.modelo;

public class ContadorDeTurno extends Contador {

    private static ContadorDeTurno instancia;

    private ContadorDeTurno() {
        this.valor = 0;
    }

    public static ContadorDeTurno obtenerContador() {
        if (instancia == null) {
            instancia = new ContadorDeTurno();
        }
        return instancia;
    }

    public int obtenerValor() {
        return this.valor;
    }
}
