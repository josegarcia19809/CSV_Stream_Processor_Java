package org.example.PersonasXMLPruebas;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonaXMLPrueba {
    public static void main(String[] args) {
        //crearDocumentoXML();
        leerDocumentoXML();
    }

    private static void crearDocumentoXML() {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement("Personas");
            doc.appendChild(rootElement);

            // Agregar elementos de Persona al documento
            addPersona(doc, rootElement, 0, "Roberto", "Tellez", 1995, 218, 6.55);
            addPersona(doc, rootElement, 1, "Maria", "González", 2013, 2, 5.67);
            addPersona(doc, rootElement, 2, "Juan", "Davila", 2003, 299, 1.99);

            // Agregar más elementos de Persona aquí según sea necesario

            // Escribir el contenido del documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("personas.xml"));
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con éxito.");


        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void leerDocumentoXML() {
        try {
            // Leer el contenido del archivo XML
            File xmlFile = new File("personas.xml");
            DocumentBuilderFactory dbFactoryRead = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilderRead = dbFactoryRead.newDocumentBuilder();
            Document docRead = dBuilderRead.parse(xmlFile);
            docRead.getDocumentElement().normalize();

            // Obtener la lista de elementos de Persona
            NodeList nodeList = docRead.getElementsByTagName("Persona");

            // Iterar sobre la lista de elementos de Persona
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("ID: " +
                            element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Nombre: " +
                            element.getElementsByTagName("nombre").item(0)
                                    .getTextContent());
                    System.out.println("Apellido: " +
                            element.getElementsByTagName("apellido").item(0)
                                    .getTextContent());
                    System.out.println("Año de nacimiento: " +
                            element.getElementsByTagName("anioNacimiento").item(0)
                                    .getTextContent());
                    System.out.println("Salario: " +
                            element.getElementsByTagName("salario").item(0)
                                    .getTextContent());
                    System.out.println("Coeficiente: " +
                            element.getElementsByTagName("coeficiente").item(0)
                                    .getTextContent());
                    System.out.println("---------------------------------------------");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    // Método para agregar un elemento Persona al documento XML
    private static void addPersona(Document doc, Element rootElement, int id,
                                   String nombre, String apellido, int anioNacimiento,
                                   int salario, double coeficiente) {
        Element persona = doc.createElement("Persona");
        rootElement.appendChild(persona);

        Element idElement = doc.createElement("id");
        idElement.appendChild(doc.createTextNode(String.valueOf(id)));
        persona.appendChild(idElement);

        Element nombreElement = doc.createElement("nombre");
        nombreElement.appendChild(doc.createTextNode(nombre));
        persona.appendChild(nombreElement);

        Element apellidoElement = doc.createElement("apellido");
        apellidoElement.appendChild(doc.createTextNode(apellido));
        persona.appendChild(apellidoElement);

        Element anioNacimientoElement = doc.createElement("anioNacimiento");
        anioNacimientoElement.appendChild(doc.createTextNode(
                String.valueOf(anioNacimiento)));
        persona.appendChild(anioNacimientoElement);

        Element salarioElement = doc.createElement("salario");
        salarioElement.appendChild(doc.createTextNode(String.valueOf(salario)));
        persona.appendChild(salarioElement);

        Element coeficienteElement = doc.createElement("coeficiente");
        coeficienteElement.appendChild(doc.createTextNode(String.valueOf(coeficiente)));
        persona.appendChild(coeficienteElement);
    }
}
