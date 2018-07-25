package com.sujiawei.java.services.impl;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println("Hello : " + msg);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello World");
	}
}
