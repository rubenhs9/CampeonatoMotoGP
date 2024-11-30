package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rubén
 */
public class FicheroCircuito {
    private static final String RUTA_FICHERO = "./res/storage/circuitos.dat";
    
    public static void guardarCircuitos(Set<Circuito> circuitos) throws FileNotFoundException, IOException{
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO))){
            os.writeObject(circuitos);
            System.out.println("DATOS GUARDADOS EN "+RUTA_FICHERO);
        }catch(IOException e){
            e.printStackTrace();
            System.err.println("ERROR AL GUARDAR LOS DATOS EN EL FICHERO :(");
        }
    }
    
    public static Set<Circuito> cargarCircuitos() throws FileNotFoundException, IOException, ClassNotFoundException{
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(RUTA_FICHERO))){
            return (Set<Circuito>) is.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. Retornando conjunto vacío.");
            return new HashSet<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error al leer los datos del fichero.");
            return new HashSet<>();
        }
    }
    
}
