package com.sujiawei.java.services.impl;

import com.sujiawei.java.services.IOutputGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class OutputHelper
{
	IOutputGenerator outputGenerator;

	public void generateOutput() {
		outputGenerator.generateOutput();
	}

	@Autowired
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
	
}