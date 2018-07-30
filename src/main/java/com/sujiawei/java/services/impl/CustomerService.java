package com.sujiawei.java.services.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class CustomerService
{
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method after properties are set : " + message);
	}
}