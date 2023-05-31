package Model;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    int vida = 20;
    int creditos = 100;
    List <Defensa> defensas = new ArrayList();

    public int getVida() {
        return vida;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public boolean puedeConstruir(int costo){
      return costo< this.creditos;
    }
    
    public void construir(Defensa defensa) throws Exception{
        if (this.puedeConstruir(defensa.costoDeConstruccion())) {
            Defensa nuevaDefensa = defensa.construir();
            defensas.add(nuevaDefensa);
        }
        else{
            throw new NoDisponeDeSuficientesCreditos();
        }
    }
    
    
    
}
