package com.example.JBS.model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {

    public static List<Recall> retrieveXMLData() {

        List<Recall> recalls = new ArrayList<>();

        try {
            File fXmlFile = new File("C:\\Users\\Prav\\Desktop\\JBS\\src\\main\\resources\\fda.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            // normalize XML response
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("recall");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Recall recall = new Recall();
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    recall.setBrand(eElement.getElementsByTagName("Brand").item(0).getTextContent());
                    recall.setCompany(eElement.getElementsByTagName("Company").item(0).getTextContent());
                    recall.setReason(eElement.getElementsByTagName("Reason").item(0).getTextContent());
                    recall.setPd(eElement.getElementsByTagName("ProductDescription").item(0).getTextContent());
                    recall.setUrl(eElement.getElementsByTagName("Url").item(0).getTextContent());
                    recall.setDate(eElement.getElementsByTagName("Date").item(0).getTextContent());

                    recalls.add(recall);

                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return recalls;
    }
}