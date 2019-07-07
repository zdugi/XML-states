package tools;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLReader {
    private static void readXML(String pathName) {
        try {
            File inputFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Document");

            Element eElement = (Element) nList.item(0);

            System.out.println(eElement.getElementsByTagName("Title").item(0).getTextContent());
            NodeList fields = eElement.getElementsByTagName("Field");

            for(int i = 0; i < fields.getLength(); i++)
            {
                Element field = (Element)fields.item(i);
                System.out.println(field.getAttribute("fieldId"));
                System.out.println(field.getAttribute("type"));
                System.out.println(field.getElementsByTagName("Name").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String path = "testInputs\\example.xml";
        readXML(path);
    }
}
