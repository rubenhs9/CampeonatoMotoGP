/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Rubén
 */
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

    @Override
    public String toString() {
        return "Piloto{" + "nombre=" + nombre + ", pais=" + pais + ", escuderia=" + escuderia + ", puntos=" + puntos + ", moto=" + moto + '}';
    }

       
}
