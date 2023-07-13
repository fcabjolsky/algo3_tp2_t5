package edu.fiuba.algo3.modelo;

public class Logger implements Observador {
    private boolean active;

    public Logger () {
        this.encender();
    }

    void apagar() {
        this.active = false;
    }

    void encender() {
        this.active = true;
    }
    @Override
    public void actualizar(Observable observable, Object argument) {
        if (this.active && (argument instanceof  String)) {
            System.out.println(argument);
        }
    }
}
