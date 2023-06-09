package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TorreView extends DefensaView {

    private DisparoAnimacion ataque;
    public TorreView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y, Pane contenedor, GridPane mapa) {
        super(urlTorreImagen, anchoTile, altoTile, x, y, mapa, contenedor);
    }

    @Override
    public void update(Entidad pasarelaAtacada){
        this.ataque = new DisparoAnimacion(this, super.anchoTile, super.altoTile);
        this.ataque.realizarAtaque(pasarelaAtacada, super.contenedor);
    }


    @Override
    public void actualizar(Observable observable, Object argument) {
        if (argument instanceof Pasarela) {
            Posicion posicionAtaque = ((Pasarela) argument).getPosicion();
            this.update(this.devolverParcela(super.mapa, posicionAtaque.getCoordenadaX(), posicionAtaque.getCoordenadaY()));
        }
    }
}
