package GUI_XML;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

public class XPathQueries {
    private final XPath xPath;
    private final Document document;
    private final List<String> resultados; // Lista para almacenar los resultados

    public XPathQueries(Document document) {
        this.document = document;
        this.xPath = XPathFactory.newInstance().newXPath();
        this.resultados = new ArrayList<>(); // Inicializamos la lista
    }

    public List<String> getResultados() {
        return resultados; // Devuelve la lista de resultados
    }

    public void mostrarCincoPrimeros() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[position() <= 5]/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    public void numeroNombreYamaha() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[data3='Yamaha']/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    public void pilotosEsp() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[contains(data1, '(ESP)')]/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    
    public void ejecutarConsultas() throws Exception {
        mostrarCincoPrimeros();
        numeroNombreYamaha();
        pilotosEsp();
    }
}
