package com.sujiawei.java.spring.xmlprase;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.Collection;

public interface ElementLoader {

    void addElement(Document doc);

    Element getElement(String id);

    Collection<Element> getElements();
}
