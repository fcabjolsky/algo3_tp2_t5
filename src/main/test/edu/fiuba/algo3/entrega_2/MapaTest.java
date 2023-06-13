package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ElFormatoDeJSONNoEsValido;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.NoSeEncontroElArchivoJSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapaTest {
    @Test
    public void noSePuedeObtenerLaInformacionDelMapaSiElArchivoNoExiste(){
        String urlInfomacionDelMapa = "mapa.json";

        assertThrows(NoSeEncontroElArchivoJSON.class, () -> new Mapa(urlInfomacionDelMapa));
    }

    @Test
    public void noSePuedeObtenerLaInformacionDelMapaSiElFormatoNoEsValido(){
        String urlInfomacionDelMapa = "src/main/java/edu/fiuba/algo3/modelo/mapaInvalido.json";
        Mapa mapa = new Mapa(urlInfomacionDelMapa);

        assertThrows(ElFormatoDeJSONNoEsValido.class, () -> mapa.obtenerInformacionDelMapa());
    }
    
    @Test 
    public void losElementosLeidosDelJsonSeCorrespondenConUnObjetoDelMapa() {
    	
    	//crear las parcelas correspondientes	
    	
    }
    
}
