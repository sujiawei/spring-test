package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

public class Ability implements Serializable
{

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;

	private String skill;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String toString() {
		return  JSON.toJSONString(this);
	}
}
