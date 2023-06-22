package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AgregadorDeEnemigos {

    private Mapa mapa;
    private Map<String, EnemigoFactory> enemigosExistentes;
    private int hormigasNuevas = 0;
    private int araniasNuevas = 0;

    private String informacionDeEnemigos;

    private interface EnemigoFactory {
        Enemigo create();
    }

    public AgregadorDeEnemigos(String URLinformacionDeEnemigos, Mapa mapa) {
        try {
            Posicion posicion = new Posicion(0, 0);
            this.enemigosExistentes = new HashMap<>();
            this.enemigosExistentes = Collections.unmodifiableMap(new HashMap<String, EnemigoFactory>() {{
                put("arana", new EnemigoFactory() {
                    public Enemigo create() {
                        return new Arania();
                    }
                });
                put("hormiga", new EnemigoFactory() {
                    public Enemigo create() {
                        return new Hormiga();
                    }
                });
            }});
            this.informacionDeEnemigos = new String(Files.readAllBytes(Paths.get(URLinformacionDeEnemigos)));
            this.mapa = mapa;
        } catch (IOException e) {
            throw new NoSeEncontroElArchivoJSON();
        }

    }

    public void obtenerInformacionDeNuevosEnemigos(int numeroDeTurno) {
        int index = numeroDeTurno - 1;
        try {
            JSONArray jsonArray = new JSONArray(this.informacionDeEnemigos);
            if (index >= jsonArray.length()) {
                index = index - ((index / jsonArray.length()) * jsonArray.length());
            }
            JSONObject enemigos = jsonArray.getJSONObject(index).getJSONObject("enemigos");
            for (String enemigo : enemigos.keySet()) {
                agregarEnemigosAMapa(this.mapa, enemigo, enemigos.getInt(enemigo));
            }
        } catch (JSONException e) {
            throw new ElFormatoDeJSONNoEsValido();
        }
    }


    private Enemigo crearEnemigo(String enemigo) {
        EnemigoFactory factory = this.enemigosExistentes.get(enemigo);
        return factory.create();
    }


    public void agregarEnemigosAMapa(Mapa mapa, String especie, int cantidad) {
        for (int i = 0; i < cantidad; i++) {

            mapa.agregarEnemigo(this.crearEnemigo(especie));
        }
    }
}
