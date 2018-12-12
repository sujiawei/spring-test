package com.sujiawei.java.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanFactoryPostProcessorTest implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(">>>>>> 设置了name属性");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        System.out.println(">>>>>> 设置了sex属性");
    }

    public BeanFactoryPostProcessorTest() {
        System.out.println(">>> 我是BeanFactoryPostProcessorTest的构造方法");
    }

    @Override
    public void setBeanFactory(BeanFactory paramBeanFactory)
            throws BeansException {
        System.out.println("》》》调用了BeanFactoryAware的setBeanFactory方法了");
    }

    @Override
    public void setBeanName(String paramString) {
        System.out.println("》》》调用了BeanNameAware的setBeanName方法了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("》》》调用了DisposableBean的destroy方法了");        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("》》》调用了Initailization的afterPropertiesSet方法了");
    }

    @Override
    public String toString() {
        return "BeanFactoryPostProcessorTest [name=" + name + ", sex=" + sex
                + "]";
    }
}