package com.cognizant.springlearn.model;

public class Country {
    private String code;
    private String name;

    // Default constructor
    public Country() {
    }

    // Parameterized constructor
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}