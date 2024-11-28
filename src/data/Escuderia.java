
package data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rubén
 */
public class Escuderia {
    
    private String nombre;
    private String Pais;
    private String rutaImagen;
    private int puntos;
    private Piloto piloto;
    private List<Piloto> pilotos = new ArrayList<>();
    private Color colorPrimario;
    private Color colorSecundario;

    public Escuderia(String nombre, String Pais, String rutaImagen,Color colorPrimario,Color colorSecundario) {
        this.nombre = nombre;
        this.Pais = Pais;
        this.rutaImagen = rutaImagen;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }
    
    public Escuderia(String nombre, String Pais, String rutaImagen) {
        this.nombre = nombre;
        this.Pais = Pais;
        this.rutaImagen = rutaImagen;
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

    public String getImagen() {
        return rutaImagen;
    }
    
    

    public int getPuntos() {
        return puntos;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public Color getColorPrimario() {
        return colorPrimario;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }
    
    
    
    
    
}
