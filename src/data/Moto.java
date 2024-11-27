
package data;


public class Moto {
    private String numero;
    private String marca;
    private String modelo;

    public Moto(String numero, String marca, String modelo) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getNumero() {
        return numero;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
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
    

