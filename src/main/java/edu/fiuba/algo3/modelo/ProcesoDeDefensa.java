package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class ProcesoDeDefensa {

    public List<Pasarela> obtenerPasarelasEnRango(Defensa defensa, List<Pasarela> pasarelas) {
        List<Pasarela> pasarelasEnRango = pasarelas.stream().
                filter(pasarela -> pasarela.defensaEstaEnRango(defensa)).
                collect(Collectors.toList());
        return pasarelasEnRango;
    }

    public Pasarela obtenerPasarelaADefender(Defensa defensa, List<Pasarela> pasarelas) {
        List<Pasarela> pasarelasEnRango = this.obtenerPasarelasEnRango(defensa, pasarelas);
        Random randomIndex = new Random();
        return pasarelasEnRango.get(randomIndex.nextInt(pasarelas.size()));
    }

    public void procesarDefensa(List<Pasarela> pasarelasConEnemigos, List<Defensa> defensas) {
        for (Defensa defensa : defensas ) {
            Pasarela pasarelaADefender = this.obtenerPasarelaADefender(defensa, pasarelasConEnemigos);
            defensa.defender(pasarelaADefender.obtenerEnemigoADaniar());
        }
    }
}
