package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Mapa extends Observable implements Turneable {

    private List<Pasarela> pasarelas;
    private List<Rocoso> rocosos;
    private List<Tierra> tierras;


    public Mapa(List<Pasarela> pasarelas, List<Rocoso> rocosos, List<Tierra> tierras) {
        this.pasarelas = pasarelas;
        this.rocosos = rocosos;
        this.tierras = tierras;
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigo.replicarObservadores(this);
        this.notificarObservadores(enemigo);
        this.notificarObservadores("Agregando enemigo: " + enemigo.toString());
        pasarelas.stream().findFirst().get().recibirEnemigo(enemigo);
    }


    public boolean contieneEnemigos() {
        for (Pasarela pasarela : this.pasarelas) {
            if (pasarela.contieneEnemigosVivos()) {
                return true;
            }
        }
        return false;
    }

    public List<Pasarela> obtenerPasarelasConEnemigos() {
        List<Pasarela> pasarelasConEnemigos = this.pasarelas.stream().
                filter(pasarela -> pasarela.contieneEnemigosVivos()).
                collect(Collectors.toList());
        return pasarelasConEnemigos;
    }

    public List<Transitable> obtenerParcelasTransitables() {
        List<Transitable> parcelasTransitables = this.pasarelas.stream()
                .filter(parcela -> parcela instanceof Transitable)
                .map(parcela -> (Transitable) parcela)
                .collect(Collectors.toList());
        return parcelasTransitables;

    }

    public List<Rocoso> getRocoso() {
        return this.rocosos;
    }

    public List<Tierra> getTierra() {
        return this.tierras;
    }

    public List<Pasarela> getPasarelas() {
        return this.pasarelas;
    }

    @Override
    public void avanzarTurno() {
        List<Turneable> parcelasTurneables = this.pasarelas.stream()
                .filter(parcela -> parcela instanceof Turneable)
                .map(parcela -> (Turneable) parcela)
                .collect(Collectors.toList());
        for (Turneable parcela : parcelasTurneables) {
            parcela.avanzarTurno();
        }
    }

    public Pasarela getPasarelaFinal(){ return this.pasarelas.get( this.pasarelas.size() - 1 ); }

    public void reseteaAlosEnemigos(){
        List<Pasarela> listPasarelas = obtenerPasarelasConEnemigos();
        for(Pasarela pasarela : listPasarelas){
            pasarela.resetearTurnoEnemigos();
        }
    }

    /*public void moverEnemigos(){
        filtrar pasarelas con enemigos
        por cada pasarela se pasa a si mismo
    }*/

}
