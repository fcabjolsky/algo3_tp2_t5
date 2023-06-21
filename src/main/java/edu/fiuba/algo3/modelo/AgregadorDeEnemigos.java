package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AgregadorDeEnemigos{

    private List<Observador> observadores = new ArrayList<>();
    private int hormigasNuevas = 0;
    private int araniasNuevas = 0;

    private String informacionDeEnemigos;

    public void notificarAObservadores(){

        for (Observador observador: this.observadores) {
            observador.actualizar();
        }
    }

    public AgregadorDeEnemigos(String URLinformacionDeEnemigos) {
        try {
            this.informacionDeEnemigos = new String(Files.readAllBytes(Paths.get(URLinformacionDeEnemigos)));
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }

    }

    public void obtenerInformacionDeNuevosEnemigos(int numeroDeTurno) {
        
        int index = numeroDeTurno - 1;
        try {
            JSONArray jsonArray = new JSONArray(this.informacionDeEnemigos);
            if ( index >= jsonArray.length() ) {
            	index = index - ((index/jsonArray.length()) * jsonArray.length());
            }
            
                JSONObject objeto = jsonArray.getJSONObject(index);
                this.hormigasNuevas = objeto.getJSONObject("enemigos").getInt("hormiga");
                this.araniasNuevas = objeto.getJSONObject("enemigos").getInt("arana");

           
            
            notificarAObservadores();
        } catch (JSONException e) {
            throw new ElFormatoDeJSONNoEsValido();
        }
    }

    public void agregarObservador(Observador observador){
        this.observadores.add(observador);
    }

    public void agregarEnemigosAObservador(List<Enemigo> enemigos, Posicion posicion){
        for (int i = 0;  i < this.hormigasNuevas ; i++){
            enemigos.add(new Hormiga());
        }
        for (int j = 0;  j < this.araniasNuevas ; j++) {
            enemigos.add(new Arania());
        }
    }
}
