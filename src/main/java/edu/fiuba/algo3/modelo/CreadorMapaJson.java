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
			int numeroDeFila = 1;
			while (mapa.has(String.valueOf(numeroDeFila))) {
            	JSONArray fil = mapa.getJSONArray(String.valueOf(numeroDeFila));
            	for(int columna  = 0; columna < fil.length(); columna++) {
            		if(fil.getString(columna).equals("Rocoso")) {
            			Rocoso roc = new Rocoso(new Posicion(columna, numeroDeFila - 1));
            			rocoso.add(roc);
            		}else if(fil.getString(columna).equals("Tierra")) {
            			Tierra tir = new Tierra(new Posicion(columna,numeroDeFila - 1));
            			tierra.add(tir);
            		}else {
            			Pasarela pas = new Pasarela(new Posicion(columna, numeroDeFila - 1));
            			pasarela.add(pas);
            		}
            	}
				numeroDeFila++;
            }
        } catch (JSONException e) {
        	System.out.println(e.getMessage());
            throw new ElFormatoDeJSONNoEsValido();
        }
		for (Pasarela p: pasarela) {
			System.out.println(p.getPosicion().getCoordenadaX()+" : " + p.getPosicion().getCoordenadaY());
		}
		return new Mapa(pasarela, rocoso, tierra);
	}
	

}
