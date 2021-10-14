package src;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
    private static int value;

    public static void main(String[] args) {
        Count count = new Count();


        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("park.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("program works");
            // Просматриваем все подэлементы корневого - т.е. растения
            NodeList parkCatalogue = root.getChildNodes();
            for (int i = 0; i < parkCatalogue.getLength(); i++) {
                Node plants = parkCatalogue.item(i);
                // Если нода не текст, то это растение - заходим внутрь
                if (plants.getNodeType() != Node.TEXT_NODE) {
                    NodeList plantsProps = plants.getChildNodes();
                    for (int j = 0; j < plantsProps.getLength(); j++) {
                        Node plantsProp = plantsProps.item(j);
                        // Если нода не текст, то это один из параметров растения - печатаем
                        if (plantsProp.getNodeType() != Node.TEXT_NODE) {
                            count.count(plantsProp.getChildNodes().item(0).getTextContent());
                        }

                    }
                    value = plantsProps.getLength();
                }

            }
            Creat.addallValue(value, count.getAllHeight());

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}