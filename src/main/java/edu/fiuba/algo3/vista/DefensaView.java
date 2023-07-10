package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Observador;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public abstract class DefensaView extends Region implements Observador {

    private Image imagen;

    protected GridPane mapa;

    protected Pane contenedor;

    int anchoTile;
    int altoTile;
    public DefensaView(String urlTorreImagen, int anchoTile, int altoTile, int x, int y, GridPane mapa, Pane contenedor) {
        this.imagen = new Image(DefensaView.class.getResourceAsStream(urlTorreImagen));
        this.contenedor = contenedor;
        this.altoTile = altoTile;
        this.anchoTile = anchoTile;
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(altoTile);
        this.setWidth(anchoTile);
        BackgroundImage fondo = new BackgroundImage(this.imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(anchoTile, altoTile, false, false, true, true));
        this.setBackground(new Background(fondo));
        this.mapa = mapa;
    }

    private Node obtenerParcelaDeMapa(GridPane mapa, int x, int y) {
        ObservableList<Node> parcelas = mapa.getChildren();
        for (Node nodo : parcelas) {
            Integer columnaIndex = GridPane.getColumnIndex(nodo);
            Integer filaIndex = GridPane.getRowIndex(nodo);
            if (columnaIndex == null){
                columnaIndex = 0;
            }
            if (filaIndex == null){
                filaIndex = 0;
            }
            if (columnaIndex == x && filaIndex == y){
                return nodo;
            }
        }
        return null;
    }
    protected ParcelaView devolverParcela(GridPane mapa, int posicionParcelaAtacadaX, int posicionParcelaAtacadaY){
        ParcelaView parcelaADevolver = null;
        try {
            parcelaADevolver = (PasarelaView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
        }catch(ClassCastException errorDeClase){
            try {
                parcelaADevolver = (TierraView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
            }catch(ClassCastException errorDeClase2){
                parcelaADevolver = (RocosoView)this.obtenerParcelaDeMapa(mapa, posicionParcelaAtacadaX, posicionParcelaAtacadaY);
            }
        }
        return parcelaADevolver;
    }
    public abstract void update(ParcelaView pasarelaAtacada);
}
