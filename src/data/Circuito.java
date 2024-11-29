package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circuito circuito = (Circuito) obj;
        return nombre.equals(circuito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Circuito o) {
        return this.nombre.compareTo(o.nombre);
    }
    
    @Override
    public String toString() {
        return "Circuito: " +
                "Nombre='" + nombre + '\'' +
                ", Pais='" + pais + '\'' +
                ", Longitud=" + longitud;
    }
    
    
    
    
}
