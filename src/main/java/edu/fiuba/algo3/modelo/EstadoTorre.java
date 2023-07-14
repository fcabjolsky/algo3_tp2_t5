package edu.fiuba.algo3.modelo;

public interface EstadoTorre extends Turneable {

    void defender(Pasarela pasarela);

    public void setTorre(Torre torre);
}