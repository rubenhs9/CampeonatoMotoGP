package data;

import java.util.ArrayList;
import java.util.List;

public class Circuito implements Comparable<Circuito>{
    private String nombre;
    private String pais;
    private double longitud;

    public Circuito(String nombre, String pais, double longitud) {
        this.nombre = nombre;
        this.pais = pais;
        this.longitud = longitud;
    }

    
    @Override
    public int compareTo(Circuito otroCircuito) {
        // Puedes comparar por nombre, país o longitud dependiendo de lo que necesites
        return this.nombre.compareTo(otroCircuito.nombre); // Comparar por nombre
    }
   
    
    @Override
    public String toString() {
        return "Circuito: " +
                "Nombre='" + nombre + '\'' +
                ", Pais='" + pais + '\'' +
                ", Longitud=" + longitud;
                
    }
    
    
    
    
}
