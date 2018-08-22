package com.sujiawei.java.spring.bean.impl;

import com.sujiawei.java.spring.bean.ApplicationContext;
import com.sujiawei.java.spring.bean.BeanCreator;
import com.sujiawei.java.spring.bean.PropertyHandler;
import com.sujiawei.java.spring.xmlprase.*;
import com.sujiawei.java.spring.xmlprase.impl.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.BeanCreationException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractApplicationContext implements ApplicationContext {

    protected ElementLoader elementLoader = new ElementLoaderImpl();

    protected DocumentHolder documentHolder = new XMLDocumentHolder();

    protected Map<String, Object> beans = new HashMap<>();

    protected BeanCreator beanCreator = new BeanCreatorImpl();

    protected ElementReader elementReader = new ElementReaderImpl();

    protected PropertyHandler propertyHandler = new PropertyHandlerImpl();

    public void setUpElements(String[] xmlPaths) {
        URL classPathUrl = AbstractApplicationContext.class.getClassLoader().getResource(".");

        String classpath;

        try {
            classpath = URLDecoder.decode(classPathUrl.getPath(), "utf-8");
            for (String path : xmlPaths) {
                Document doc = documentHolder.getDocument(classpath + path);

                elementLoader.addElement(doc);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {

        Object bean = beans.get(id);
        if (bean == null) {
            bean = handleSingleton(id);
        }
        return bean;
    }

    @Override
    public boolean containsBean(String id) {
        Element element = elementLoader.getElement(id);
        return element != null;
    }

    @Override
    public boolean isSingleton(String id) {
        Element element = elementLoader.getElement(id);
        return elementReader.isSingleTon(element);
    }

    private Object handleSingleton(String id) {
        Object bean = createBean(id);
        if (isSingleton(id)) {
            beans.put(id, bean);
        }
        return bean;
    }

    private Object createBean(String id) {
        Element e = elementLoader.getElement(id);
        if (e == null) {
            try {
                throw new BeanCreationException("element not found" + id);
            } catch (BeanCreationException e1) {
                e1.printStackTrace();
            }
        }

        Object result = instance(e);
        System.out.println("创建Bean" + id);
        System.out.println("该Bean的对象是" + result);

        AutoWire autoWire = elementReader.getAutoWire(e);

        if (autoWire instanceof ByNameAutoWire) {
            autoWireByName(result);
        } else if (autoWire instanceof NoAutoWire) {
            setterInject(result, e);
        }

        return result;
    }

    private Object instance(Element e) {
        String className = elementReader.getAttribute(e, "class");

        List<Element> constructorElements = elementReader.getConstructorElements(e);

        if (constructorElements.size() == 0) {
            return beanCreator.createBeanUseDefaultConstruct(className);
        } else {
            List<Object> args = getConstructArgs(e);
            return beanCreator.createBeanUseDefineConstruce(className, args);
        }
    }

    private List<Object> getConstructArgs(Element e) {
        List<DataElement> datas = elementReader.getConstructorValue(e);
        List<Object> result = new ArrayList<>();

        for (DataElement d : datas) {
            if (d instanceof ValueElement) {
                //d = (ValueElement) d;
                result.add(d.getValue());
            } else if (d instanceof RefElement) {
                String refid = d.getValue().toString();
                result.add(getBean(refid));
            }
        }
        return result;
    }

    private void autoWireByName(Object obj) {
        Map<String, Method> methods = propertyHandler.getSetterMethodsMap(obj);

        for (String s : methods.keySet()) {
            Element e = elementLoader.getElement(s);
            if (e == null) continue;

            Object bean = getBean(s);
            Method method = methods.get(s);
            propertyHandler.executeMethod(obj, bean, method);
        }
    }

    private void setterInject(Object obj, Element e) {
        List<PropertyElement> properties = elementReader.getPropertyValue(e);

        Map<String, Object> propertiesMap = getPropertyArgs(properties);

        propertyHandler.setProperties(obj, propertiesMap);
    }

    private Map<String, Object> getPropertyArgs(List<PropertyElement> properties) {
        Map<String, Object> result = new HashMap<>();

        for (PropertyElement p : properties) {
            DataElement de = p.getValue();
            if (de instanceof RefElement) {
                result.put(p.getName(), getBean(de.getValue().toString()));
            } else if (de instanceof ValueElement) {
                result.put(p.getName(), de.getValue());
            }
        }
        return result;
    }

}
