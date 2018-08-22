package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.AutoWire;
import com.sujiawei.java.spring.xmlprase.DataElement;
import com.sujiawei.java.spring.xmlprase.ElementReader;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ElementReaderImpl implements ElementReader {

    @Override
    public boolean isLazy(Element element) {

        String lazy = getAttribute(element, "lazy-init");

        Element parent = element.getParent();

        Boolean parentLazy = new Boolean(getAttribute(parent, "default-lazy-init"));

        if (parentLazy) {
            if ("false".equals(lazy)) return false;
            return true;
        } else {
            if ("true".equals(lazy)) return true;
            return false;
        }
    }

    @Override
    public List<Element> getConstructorElements(Element element) {

        List<Element> childrens = element.elements();  //得到bean节点下所有节点

        List<Element> result = new ArrayList<>();

        for (Element e : childrens) {
            if ("constructor-arg".equals(e.getName())) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public String getAttribute(Element element, String name) {

        String value = element.attributeValue(name);
        return value;
    }

    @Override
    public boolean isSingleTon(Element element) {

        Boolean singleTon = new Boolean(getAttribute(element, "singleTon"));
        return singleTon;
    }

    @Override
    public List<Element> getPropertyElements(Element element) {

        List<Element> elements = element.elements();
        return elements;
    }

    @Override
    public AutoWire getAutoWire(Element element) {

        String value = getAttribute(element, "autowire");

        String parentValue = getAttribute(element.getParent(), "default-autowire");
        parentValue = (parentValue == null) ? "no" : parentValue;

        if ("no".equals(parentValue)) {
            if ("byName".equals(value)) {
                return new ByNameAutoWire(value);
            } else {
                return new NoAutoWire(value);
            }
        } else if ("byName".equals(parentValue)) {
            if ("no".equals(value)) return new NoAutoWire(value);
            return new ByNameAutoWire(value);
        }
        return new NoAutoWire(value);
    }

    @Override
    public List<DataElement> getConstructorValue(Element element) {

        List<Element> cons = getConstructorElements(element);

        List<DataElement> result = new ArrayList<>();

        for (Element e : cons) {
            List<Element> els = e.elements();

            DataElement dataElement = getDataElement(els.get(0));

            result.add(dataElement);
        }
        return result;
    }

    @Override
    public List<PropertyElement> getPropertyValue(Element element) {

        List<Element> properties = getPropertyElements(element);

        List<PropertyElement> result = new ArrayList<>();

        for (Element e : properties) {
            //List<Element> els = e.elements();

            DataElement dataElement = getDataElement(e);

            String value = getAttribute(e, "name");

            PropertyElement pe = new PropertyElement(value, dataElement);
            result.add(pe);
        }
        return result;
    }

    private DataElement getDataElement(Element element) {

        String value = getAttribute(element, "value");
        String ref = getAttribute(element, "ref");

        if (!StringUtils.isEmpty(value)) {
            String classTypeName = element.attributeValue("type") == null ? "String" : element.attributeValue("type");

            return new ValueElement(getValue(classTypeName, value));
        } else if (!StringUtils.isEmpty(ref)) {
            return new RefElement(getAttribute(element, "bean"));
        }
        return null;
    }

    private Object getValue(String className, String data) {
        if (isType(className, "Integer")) {
            return Integer.parseInt(data);
        } else {
            return data;
        }
    }

    private boolean isType(String className, String type) {
        return className.contains(type);
    }

}
