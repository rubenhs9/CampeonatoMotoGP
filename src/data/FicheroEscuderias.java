

package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FicheroEscuderias {
    
    private static final String RUTA_FICHERO_ESCUDERIAS = ".\\res\\storage\\escuderias.dat";
    private static final String RUTA_FICHERO_ESCUDERIAS_COMPLETO = ".\\res\\storage\\escuderias_completo.dat";
    private static File archivo;
    
    //Guardar escuderías en un archivo
    public static void guardarFichero(List<Escuderia> escuderias) throws IOException {
        //Validar si el archivo no existe, se crea automáticamente al abrir FileOutputStream
        File archivo = new File(RUTA_FICHERO_ESCUDERIAS);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            // Serializamos solo el nombre de la escudería y los nombres de los pilotos
            List<Map<String, List<String>>> datosSerializados = new ArrayList<>();
            for (Escuderia escuderia : escuderias) {
                System.out.println(escuderia.getNombre());
                Map<String, List<String>> escuderiaInfo = new HashMap<>();
                List<String> nombresPilotos = new ArrayList<>();
                for (Piloto piloto : escuderia.getPilotos()) {
                    System.out.println(" -" + piloto.getNombre());
                    nombresPilotos.add(piloto.getNombre());
                }
                escuderiaInfo.put(escuderia.getNombre(), nombresPilotos);
                datosSerializados.add(escuderiaInfo);
            }
            oos.writeObject(datosSerializados);
        }
    }

    // Cargar escuderías desde un archivo
    public static void cargarFichero(List<Escuderia> escuderias, List<Piloto> pilotos, boolean ficheroCompleto) throws IOException, ClassNotFoundException {
        if (!ficheroCompleto) {
           archivo = new File(RUTA_FICHERO_ESCUDERIAS); 
        }else{
            archivo = new File(RUTA_FICHERO_ESCUDERIAS_COMPLETO); 
        }
        

        // Si el archivo no existe, no hace falta intentar leerlo
        if (!archivo.exists()) {
            System.out.println("El fichero no existe, no hay datos para cargar.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            List<Map<String, List<String>>> datosSerializados = (List<Map<String, List<String>>>) ois.readObject();

            for (Map<String, List<String>> escuderiaInfo : datosSerializados) {
                for (Map.Entry<String, List<String>> entry : escuderiaInfo.entrySet()) {
                    String nombreEscuderia = entry.getKey();
                    List<String> nombresPilotos = entry.getValue();

                    Escuderia escuderiaEncontrada = null;

                    // Buscar la escudería correspondiente en la lista actual
                    for (Escuderia escuderia : escuderias) {
                        if (escuderia.getNombre().equals(nombreEscuderia)) {
                            escuderiaEncontrada = escuderia;
                            break;
                        }
                    }

                    // Si la escudería se encontró, añadir los pilotos correspondientes
                    if (escuderiaEncontrada != null) {
                        for (String nombrePiloto : nombresPilotos) {
                            for (Piloto piloto : pilotos) {
                                if (piloto.getNombre().equals(nombrePiloto)) {
                                    // Verificar que no se añada un piloto duplicado
                                    if (!escuderiaEncontrada.getPilotos().contains(piloto)) {
                                        escuderiaEncontrada.getPilotos().add(piloto);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    
}
