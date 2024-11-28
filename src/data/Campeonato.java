
package data;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Campeonato  {
    private List<Moto> motos = new ArrayList<>();
    
    private Set<Circuito> circuitos = new TreeSet<>();
    private List<Escuderia> escuderias = new ArrayList<>();
    
    private String nombreCampeonato;
    private Font fuenteMotoGP;

    public Campeonato(String nombre) {
        this.nombreCampeonato = nombre;
        crearFuenteMotoGP();
    }

    public Campeonato() {
    }

    private void crearFuenteMotoGP(){
        try {
            //Especificar la ruta del archivo .ttf
            String rutaArchivoTTF = ".\\res\\fonts\\MotoGPDisplay-Bold.ttf";

            //Crea un objeto File con la ruta del archivo .ttf
            File archivoTTF = new File(rutaArchivoTTF);

            //Carga la fuente desde el archivo .ttf
           fuenteMotoGP = Font.createFont(Font.TRUETYPE_FONT, archivoTTF);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
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

    public Font getFuenteMotoGP() {
        return fuenteMotoGP;
    }
    
    
    
    
}
