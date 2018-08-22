package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.DataElement;

public class PropertyElement {

    private String name;

    private DataElement value;

    public DataElement getValue() {
        return value;
    }

    public void setValue(DataElement value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public PropertyElement(String value, DataElement dataElement) {
        this.name = value;
        this.value = dataElement;
    }

}
