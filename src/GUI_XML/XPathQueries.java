
package GUI_XML;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class XPathQueries {
    private final XPath xPath;
    private final Document document;

    public XPathQueries(Document document) {
        this.document = document;
        this.xPath = XPathFactory.newInstance().newXPath();
    }

    public void getSatellitesNames() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//satelite/@nombre", document, XPathConstants.NODESET);
        System.out.println("Nombres de todos los satélites:");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("- " + nodes.item(i).getNodeValue());
        }
    }

    public void getPlanetsWithSatelliteNamedLuna() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//planeta[satelite[@nombre='Luna']]/@nombre", document, XPathConstants.NODESET);
        System.out.println("Planetas con satélite llamado 'Luna':");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("- " + nodes.item(i).getNodeValue());
        }
    }

    public void getSpacesWithAttributeName() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//espacio[@nombre]", document, XPathConstants.NODESET);
        System.out.println("Espacios con atributo 'nombre':");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("- " + nodes.item(i).getNodeValue());
        }
    }

    public void getGalaxiesWithAttributeName() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//galaxia/@nombre", document, XPathConstants.NODESET);
        System.out.println("Galaxias con atributo 'nombre':");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("- " + nodes.item(i).getNodeValue());
        }
    }

    public void getNodesWithNameNotLuna() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//*[not(@nombre='Luna')]/@nombre", document, XPathConstants.NODESET);
        System.out.println("Nodos cuyo nombre no sea 'Luna':");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("- " + nodes.item(i).getNodeValue());
        }
    }
}
