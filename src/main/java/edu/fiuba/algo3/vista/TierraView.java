package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Posicion;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TierraView extends Entidad {
    public TierraView(Posicion posicion, int anchoTile, int altoTile) {
        super(posicion, anchoTile, altoTile);
        try{
            super.imagen = ImageIO.read(getClass().getResource("/tierra.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entidad devolverNuevaInstancia(Posicion posicion, int anchoTile, int altoTile) {

        return (new TierraView(posicion, anchoTile, altoTile));
    }
}
