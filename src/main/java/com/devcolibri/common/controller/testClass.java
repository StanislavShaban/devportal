package com.devcolibri.common.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by s on 08.11.16.
 */
public class testClass {

    private String name;
    private int nameID;

    public testClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameID() {
        return nameID;
    }

    public void setNameID(int nameID) {
        this.nameID = nameID;
    }

    public testClass(String name, int nameID) {
        this.name = name;
        this.nameID = nameID;
    }



    public String testMethod(String name){
        name += " Shaban";
        return name;
    }
}
