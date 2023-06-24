package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;

import javax.imageio.ImageIO;
import java.io.IOException;

public class RocosoView extends Entidad {

    public RocosoView(Posicion posicion, int anchoTile, int altoTile) {
        super(posicion, anchoTile, altoTile);
        try{
            super.imagen = ImageIO.read(getClass().getResource("/rocoso.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entidad devolverNuevaInstancia(Posicion posicion, int anchoTile, int altoTile) {

        return (new RocosoView(posicion, anchoTile, altoTile));
    }
}
