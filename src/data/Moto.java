/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Rubén
 */
public class Moto {
    private String numero;
    private String marca;
    private String modelo;

        public Moto(String numero, String marca, String modelo) {
            this.numero = numero;
            this.marca = marca;
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return "Moto{" +
                    "numero='" + numero + '\'' +
                    ", marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    '}';
        }
    }
    

