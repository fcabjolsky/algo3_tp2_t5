package edu.fiuba.algo3.modelo;

public class ContadorDeMuertesDeHormiga extends Contador {

    private static ContadorDeMuertesDeHormiga instancia;

    private ContadorDeMuertesDeHormiga() {
        this.valor = 0;
    }

        public static ContadorDeMuertesDeHormiga obtenerContador() {
        if (instancia == null) {
            instancia = new ContadorDeMuertesDeHormiga();
        }
        return instancia;
    }

}
