package data;

import java.util.ArrayList;
import java.util.List;

public class Circuito implements Comparable<Circuito>{
    private String nombre;
    private String pais;
    private String imagen;
    private double longitud;

    public Circuito(String nombre, String pais, double longitud, String imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    
    @Override
    public int compareTo(Circuito otroCircuito) {
        // Puedes comparar por nombre, país o longitud dependiendo de lo que necesites
        return this.nombre.compareTo(otroCircuito.nombre); // Comparar por nombre
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getPais() {
        return pais;
    }

    public double getLongitud() {
        return longitud;
    }
    
    
    
   
    
    @Override
    public String toString() {
        return "Circuito: " +
                "Nombre='" + nombre + '\'' +
                ", Pais='" + pais + '\'' +
                ", Longitud=" + longitud;
    }
    
    
    
    
}
