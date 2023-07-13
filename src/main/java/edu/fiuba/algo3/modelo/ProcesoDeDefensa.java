package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class ProcesoDeDefensa {

    public List<Pasarela> obtenerPasarelasEnRangoConEnemigosVivos(Defensa defensa, List<Pasarela> pasarelas) {
        List<Pasarela> pasarelasEnRangoConEnemigosVivos = pasarelas.stream().
                filter(pasarela -> pasarela.defensaEstaEnRango(defensa)).
                filter(pasarela -> pasarela.contieneEnemigosVivos()).
                collect(Collectors.toList());
        return pasarelasEnRangoConEnemigosVivos;
    }

    public Pasarela obtenerPasarelaADefender(Defensa defensa, List<Pasarela> pasarelas) {
        List<Pasarela> pasarelasEnRangoConEnemigosVivos = this.obtenerPasarelasEnRangoConEnemigosVivos(defensa, pasarelas);
        Random randomIndex = new Random();
        return pasarelasEnRangoConEnemigosVivos.get(randomIndex.nextInt(pasarelasEnRangoConEnemigosVivos.size()));
    }

    public void procesarDefensa(List<Pasarela> pasarelasConEnemigos, List<Defensa> defensas) {
        for (Defensa defensa : defensas ) {
            if (!this.obtenerPasarelasEnRangoConEnemigosVivos(defensa, pasarelasConEnemigos).isEmpty()) {
                Pasarela pasarelaADefender = this.obtenerPasarelaADefender(defensa, pasarelasConEnemigos);
                defensa.defender(pasarelaADefender);
                }
            }
        }
}



