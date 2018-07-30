package com.sujiawei.java.services.impl;

import com.sujiawei.java.core.CustomerBo;
import com.sujiawei.java.services.IOutputGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class OutputHelper
{

	public CustomerBo getCustomerBo() {
		return customerBo;
	}

	public void setCustomerBo(CustomerBo customerBo) {
		this.customerBo = customerBo;
	}

	@Autowired
	private CustomerBo customerBo;

	IOutputGenerator outputGenerator;

	public void generateOutput() {
		outputGenerator.generateOutput();
	}

	@Autowired
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}

}