
package data;


public class Piloto {
    private String nombre;
    private Pais pais;
    private String escuderia;
    private int puntos;
    private Moto moto;
    private String rutaImagenPiloto;

    public Piloto(String nombre, Pais pais, String escuderia, int puntos, Moto moto,String rutaImagenPiloto) {
        this.nombre = nombre;
        this.pais = pais;
        this.escuderia = escuderia;
        this.puntos = puntos;
        this.moto = moto;
        this.rutaImagenPiloto = rutaImagenPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public Pais getPais() {
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

    public String getRutaImagenPiloto() {
        return rutaImagenPiloto;
    }
    
    
    
    @Override
    public String toString() {
        return "Piloto{" + "nombre=" + nombre + ", pais=" + pais + ", escuderia=" + escuderia + ", puntos=" + puntos + ", moto=" + moto + '}';
    }

       
}
