
package data;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Campeonato  {
    private List<Moto> motos = new ArrayList<>();
    private List<Piloto> pilotos = new ArrayList<>();
    private Set<Circuito> circuitos = new TreeSet<>();
    private Set<Circuito> circuitosAdd = new HashSet<>();
    private List<Escuderia> escuderias = new ArrayList<>();
    
    
    private String nombreCampeonato;
    private Font fuenteMotoGP;

    public Campeonato(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.nombreCampeonato = nombre;
        this.circuitosAdd =  new HashSet<>();
        crearFuenteMotoGP();
        
        FicheroEscuderias.cargarFichero(escuderias, pilotos);
        
        this.circuitosAdd = FicheroCircuito.cargarCircuitos();
        //JESUS, ESTE HILO ES EL QUE GUARDA LOS DATOS CUANDO SE CIERRA LA APP :D
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { 
            try { 
                FicheroEscuderias.guardarFichero(escuderias);
                FicheroCircuito.guardarCircuitos(this.circuitosAdd);
            } catch (IOException ex) {
                Logger.getLogger(Campeonato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
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

    public void addCircuitos(Circuito circuito) {
        circuitos.add(circuito); // Añadir el circuito solo si no está ya en la lista
    }
    
    public void addCircuitosAdd(Circuito circuito) {
        circuitosAdd.add(circuito); // Añadir el circuito solo si no está ya en la lista
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

    public void addPilotos(Piloto piloto1, Piloto piloto2) {
        pilotos.add(piloto1);
        pilotos.add(piloto2);
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public Set<Circuito> getCircuitos() {
        return circuitos;
    }

    public Set<Circuito> getCircuitosAdd() {
        return circuitosAdd;
    }
    public void setCircuitosAdd(Set<Circuito> circuitosAdd) {
        this.circuitosAdd = circuitosAdd;
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
