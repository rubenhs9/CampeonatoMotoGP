
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rubén
 */
public class Escuderia {
    
    private String nombre;
    private String Pais;
    private int puntos;
    private Piloto piloto;
    private List<Piloto> pilotos = new ArrayList<>();

    public Escuderia(String nombre, String Pais) {
        this.nombre = nombre;
        this.Pais = Pais;
    }
    

    public void addPilotos(Piloto piloto3, Piloto piloto4) {
        pilotos.add(piloto3);
        pilotos.add(piloto4);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return Pais;
    }

    public int getPuntos() {
        return puntos;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }
    
    
    
    
    
}
