package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.DocumentHolder;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
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
}
