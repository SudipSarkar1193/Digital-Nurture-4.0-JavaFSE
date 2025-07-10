package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.model.CountryList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.List;

@Service
public class CountryService {

    private List<Country> countries;

    @PostConstruct
    public void init() throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("country.xml");
        JAXBContext context = JAXBContext.newInstance(CountryList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CountryList countryList = (CountryList) unmarshaller.unmarshal(is);
        this.countries = countryList.getCountries();
    }

    public Country getCountry(String code) throws Exception {
        for(Country con : countries){
            if (con.getCode().equalsIgnoreCase(code)) {
                return con;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found for country code: " + code);
    }
}
