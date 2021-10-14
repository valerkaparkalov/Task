package src;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Creat {

    public static void addallValue(int value, double count) throws TransformerFactoryConfigurationError, DOMException, ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //root elements
        Document doc = docBuilder.newDocument();

        Node root = doc.getDocumentElement();

        //  <characteristic>
        Element characteristic = doc.createElement("Characteristic");
        // <quantity>
        Element quantity = doc.createElement("QuantityAllPlants");
        // Устанавливаем значение текста внутри тега
        quantity.setTextContent("quantity : " + value);
        // <height>
        Element height = doc.createElement("Height");
        height.setTextContent("height :" + count);


        // Добавляем внутренние элементы книги в элемент <charactristic>
        characteristic.appendChild(quantity);
        characteristic.appendChild(height);
        // Добавляем сведенья в корневой элемент
        doc.appendChild(characteristic);

        // Записываем XML в файл
        writeDocument(doc);
    }

    // Функция для сохранения DOM в файл
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Date date = new Date();
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("characteristic.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
