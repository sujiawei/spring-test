package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("bookBean")
public class Book implements Serializable {

    @Value("#{itemBean}")
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Value("#{itemBean.name}")
    private String itemName;

    public String toString() {
        return JSON.toJSONString(this);
    }
}
