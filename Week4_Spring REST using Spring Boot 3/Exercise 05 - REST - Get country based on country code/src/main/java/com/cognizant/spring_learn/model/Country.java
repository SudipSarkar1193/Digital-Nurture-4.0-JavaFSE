package com.cognizant.spring_learn.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public class Country {
    private String code;
    private String name;

    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase(); // Following convention
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
