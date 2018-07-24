package com.sujiawei.java.bean;

public class Worker {

    private Person person;

    public Worker(Person person) {
        this.person = person;
    }

    public Worker() {

    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
