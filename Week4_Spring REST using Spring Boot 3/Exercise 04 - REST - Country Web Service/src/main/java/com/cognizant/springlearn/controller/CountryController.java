package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {
        // Load the Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Get the India bean
        Country country = (Country) context.getBean("india");
        return country;
    }
}