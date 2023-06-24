package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PasarelaView extends Entidad {

    public PasarelaView(Posicion posicion, int anchoTile, int altoTile) {
        super(posicion, anchoTile, altoTile);
        try{
            super.imagen = ImageIO.read(getClass().getResource("/pasarela.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entidad devolverNuevaInstancia(Posicion posicion, int altoTile, int anchoTile) {
        return (new PasarelaView(posicion, anchoTile, altoTile));
    }

}
