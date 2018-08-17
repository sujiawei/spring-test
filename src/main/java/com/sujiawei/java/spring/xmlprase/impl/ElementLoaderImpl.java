package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.ElementLoader;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementLoaderImpl implements ElementLoader {

    private Map<String, Element> elements = new HashMap<>();

    @Override
    public void addElement(Document doc) {

        @SuppressWarnings("unchecked")
        List<Element> eles = doc.getRootElement().elements();

        for (Element e : eles) {
            String id = e.attributeValue("id");
            elements.put(id, e);
        }
    }

    @Override
    public Element getElement(String id) {
        return elements.get(id);
    }

    @Override
    public Collection<Element> getElements() {
        return elements.values();
    }
}
