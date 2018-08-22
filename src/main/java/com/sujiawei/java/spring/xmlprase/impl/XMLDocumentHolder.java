package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.DocumentHolder;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLDocumentHolder implements DocumentHolder {

    private Map<String, Document> docs = new HashMap<>();

    @Override
    public Document getDocument(String filePath) {
        Document doc = this.docs.get(filePath);

        if (doc == null) {
            this.docs.put(filePath, readDocument(filePath));
        }
        return this.docs.get(filePath);
    }

    private Document readDocument(String filePath) {
        Document doc = null;

        try {
            SAXReader reader = new SAXReader();
            //reader.setEntityResolver(new IocEntityResolver());

            File xmlFile = new File(filePath);
            doc = reader.read(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) throws Exception{
        XMLDocumentHolder xmlDocumentHolder = new XMLDocumentHolder();
        String filePath = "bean/spring-department.xml";
        URL classPathUrl = XMLDocumentHolder.class.getClassLoader().getResource(".");
        String classpath = URLDecoder.decode(classPathUrl.getPath(), "utf-8");
        Document doc = xmlDocumentHolder.readDocument(classpath + filePath);

        System.out.println("Root element = " + doc.getRootElement().getName());
        Element element = doc.getRootElement();
        List<Element> elementList = element.elements();
        for (Element element1 : elementList) {
            System.out.println(element1.getName());
            System.out.println(element1.attributeValue("id"));
            System.out.println(element1.attributeValue("class"));
            System.out.println("------------------------------");
            List<Element> elements = element1.elements();
            for (Element element2 : elements) {
                System.out.println(element2.getName());
                System.out.println(element2.attributeValue("name"));
                System.out.println(element2.attributeValue("value"));
                System.out.println("++++++++++++++++++++++++++++");
            }
        }
    }
}
