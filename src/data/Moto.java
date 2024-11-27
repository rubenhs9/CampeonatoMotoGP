
package data;


public class Moto {
    private String numero;
    private String marca;
    private String modelo;
    private String rutaimagenMoto;

    public Moto(String numero, String marca, String modelo, String rutaimagenMoto) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.rutaimagenMoto = rutaimagenMoto;
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

    public String getRutaimagenMoto() {
        return rutaimagenMoto;
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
    

