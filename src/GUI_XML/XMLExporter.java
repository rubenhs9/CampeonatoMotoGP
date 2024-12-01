
package GUI_XML;

import data.Campeonato;
import data.Circuito;
import data.Escuderia;
import data.Piloto;
import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLExporter {
    
    public void exportarCampeonato(Campeonato campeonato, String archivoSalida) {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Nodo raíz
            Element campeonatoElement = doc.createElement("campeonato");
            doc.appendChild(campeonatoElement);

            // Escuderías
            Element escuderiasElement = doc.createElement("escuderias");
            campeonatoElement.appendChild(escuderiasElement);

            for (Escuderia escuderia : campeonato.getEscuderias()) {
                Element escuderiaElement = doc.createElement("escuderia");
                escuderiasElement.appendChild(escuderiaElement);
                agregarElemento(doc, escuderiaElement, "nombre", escuderia.getNombre());

                for (Piloto piloto : escuderia.getPilotos()) {
                    Element pilotoElement = doc.createElement("piloto");
                    escuderiaElement.appendChild(pilotoElement);

                    // Añadir los datos del piloto
                    agregarElemento(doc, pilotoElement, "nombre", piloto.getNombre());
                    agregarElemento(doc, pilotoElement, "pais", piloto.getPais().name());
                    agregarElemento(doc, pilotoElement, "moto", piloto.getMoto().getModelo());
                    agregarElemento(doc, pilotoElement, "puntos", String.valueOf(piloto.getPuntos()));
                }
            }

            // Circuitos
            Element circuitosElement = doc.createElement("circuitos");
            campeonatoElement.appendChild(circuitosElement);

            for (Circuito circuito : campeonato.getCircuitos()) {
                Element circuitoElement = doc.createElement("circuito");
                circuitosElement.appendChild(circuitoElement);

                // Añadir los datos del circuito
                agregarElemento(doc, circuitoElement, "nombre", circuito.getNombre());
                agregarElemento(doc, circuitoElement, "pais", circuito.getPais());
                agregarElemento(doc, circuitoElement, "longitud", String.valueOf(circuito.getLongitud()));
            }

            // Guardar el documento en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoSalida));

            transformer.transform(source, result);

//            System.out.println("Archivo XML exportado correctamente a: " + archivoSalida);
            
            String nombreArchivo = "campeonato2024.xml";
            String rutaGuardado = "res\\storage\\campeonato2024.xml";
            String mensaje = "<html><div style='text-align: center;'>El archivo " + nombreArchivo + 
            " ha sido guardado exitosamente en:<br>" + rutaGuardado + "</div></html>";
            JOptionPane.showMessageDialog(null, mensaje, "CONFIRMADO", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            String mensaje = "<html><div style='text-align: center;'>Ha ocurrido un error al exportar el campeonato:<br> " + 
                  e.getMessage()  + "</div></html>";

                JOptionPane.showMessageDialog(null, mensaje, "CONFIRMADO", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Método auxiliar para añadir un elemento con texto
    private void agregarElemento(Document doc, Element padre, String nombre, String texto) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(texto));
        padre.appendChild(elemento);
    }
}
