
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Campeonato  {
    private List<Moto> motos = new ArrayList<>();
    
    private Set<Circuito> circuitos = new TreeSet<>();
    private List<Escuderia> escuderias = new ArrayList<>();
    
    private String nombreCampeonato;

    public Campeonato(String nombre) {
        this.nombreCampeonato = nombre;
    }


    public void addCircutios(Circuito circuito){
        circuitos.add(circuito);
    }
    
    public void mostrarCircuitos(){
        for (Circuito circuito : circuitos) {
            System.out.println("-"+circuito);
        }
    }
    
    public void addEscuderia(Escuderia escuderia1) {
        escuderias.add(escuderia1);
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public Set<Circuito> getCircuitos() {
        return circuitos;
    }

    public List<Escuderia> getEscuderias() {
        return escuderias;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }
    
    
    
    
}
