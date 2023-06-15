package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreadorMapaJson implements CreadorDeMapa{
	
	private String informacionDeMapa;

	public CreadorMapaJson(String urlInformacionDeMapa) {
		
		try {
            this.informacionDeMapa = new String(Files.readAllBytes(Paths.get(urlInformacionDeMapa)));
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }
	}
	
	public Mapa crearMapa() {
		ArrayList<Rocoso> rocoso = new ArrayList<>();
		ArrayList<Pasarela> pasarela = new ArrayList<>();
		ArrayList<Tierra> tierra = new ArrayList<>();
		try {
            JSONObject json = new JSONObject(this.informacionDeMapa);          
			JSONObject mapa = json.getJSONObject("Mapa");
			
            for(String fila: mapa.keySet()) {
            	int numeroFila = Integer.parseInt(fila) - 1;
            	JSONArray fil = mapa.getJSONArray(fila);
            	for(int i  = 0; i < fil.length(); i++) {
            		if(fil.getString(i).equals("Rocoso")) {
            			Rocoso roc = new Rocoso(new Posicion(numeroFila, i));
            			rocoso.add(roc);
            		}else if(fil.getString(i).equals("Tierra")) {
            			Tierra tir = new Tierra(new Posicion(numeroFila, i));
            			tierra.add(tir);
            		}else {
            			Pasarela pas = new Pasarela(new Posicion(numeroFila, i));
            			pasarela.add(pas);
            		}
            	}
            }
        } catch (JSONException e) {
        	System.out.println(e.getMessage());
            throw new ElFormatoDeJSONNoEsValido();
        }
		return new Mapa(pasarela, rocoso, tierra);
	}
	

}
