
package data;


public class Piloto {
    private String nombre;
    private String pais;
    private String escuderia;
    private int puntos;
    private Moto moto;

    public Piloto(String nombre, String pais, String escuderia, int puntos, Moto moto) {
        this.nombre = nombre;
        this.pais = pais;
        this.escuderia = escuderia;
        this.puntos = puntos;
        this.moto = moto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public Moto getMoto() {
        return moto;
    }
    
    @Override
    public String toString() {
        return "Piloto{" + "nombre=" + nombre + ", pais=" + pais + ", escuderia=" + escuderia + ", puntos=" + puntos + ", moto=" + moto + '}';
    }

       
}
