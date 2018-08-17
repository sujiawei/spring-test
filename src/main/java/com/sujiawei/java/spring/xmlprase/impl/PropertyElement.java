package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.DataElement;

public class PropertyElement {

    private String name;

    private String value;

    private DataElement dataElement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DataElement getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElement dataElement) {
        this.dataElement = dataElement;
    }

    public PropertyElement(String value, DataElement dataElement) {
        this.value = value;
        this.dataElement = dataElement;
    }

}
