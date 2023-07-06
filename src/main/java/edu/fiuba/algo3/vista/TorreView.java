package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Pasarela;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TorreView extends DefensaView implements Observador{

    private DisparoAnimacion ataque;
    public TorreView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y, Pane contenedor, GridPane mapa) {
        super(urlTorreImagen, anchoTile, altoTile, x, y, mapa);
        this.ataque = new DisparoAnimacion(this, anchoTile, altoTile);
        contenedor.getChildren().add(this.ataque);
    }

    @Override
    public void update(Entidad pasarelaAtacada){
        this.ataque.realizarAtaque(pasarelaAtacada);
    }


    @Override
    public void actualizar(Observable observable, Object argument) {
        if (argument instanceof Pasarela){
            Posicion posicionAtaque = ((Pasarela)argument).getPosicion();
            System.out.println("estoy atacando a x:"+ posicionAtaque.getCoordenadaX()+ "y: "+ posicionAtaque.getCoordenadaY());
            this.update(this.devolverParcela(super.mapa, posicionAtaque.getCoordenadaX(), posicionAtaque.getCoordenadaY()));
        } else if (argument instanceof  String) {
            System.out.println(argument);
        }
    }
}
