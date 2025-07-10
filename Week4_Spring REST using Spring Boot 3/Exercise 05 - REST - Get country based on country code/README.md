# 🌍 Spring Boot REST API - Get Country by Code

This is a simple Spring Boot REST application that returns a country's details (code and name) based on the provided country code. The country data is stored in an XML file and loaded at application startup using JAXB.

---

## 📁 Project Structure

```bash
src
├── main
│ ├── java
│ │ └── com.cognizant.spring_learn
│ │ ├── SpringLearnApplication.java
│ │ ├── controller
│ │ │ └── CountryController.java
│ │ ├── model
│ │ │ └── Country.java
│ │ ├── service
│ │ │ └── CountryService.java
│ │ └── wrapper
│ │ └── CountryList.java
│ └── resources
│ ├── application.properties
│ └── country.xml
```


---

## 🧪 Sample API Usage

### ✅ GET Country by Code (Case Insensitive)

**Request**

GET http://localhost:8080/countries/in


**Response**
```json
{
  "code": "IN",
  "name": "India"
}
```

## Output Screenshot

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2005%20-%20REST%20-%20Get%20country%20based%20on%20country%20code/Output_Screenshot/Output.png?raw=true)

## 📝 Features

- Country details fetched from an XML file (country.xml)

- `@RestController` using `@GetMapping`

- `@PostConstruct` to load XML on app startup

- Case-insensitive search

- Clean separation: Controller ↔ Service ↔ Model

- Error handling for not found country

### ⚙️ How It Works

- CountryService reads `country.xml` and unmarshals it into a list of Country objects using `JAXB`.

- CountryController exposes a GET API that accepts the country code.

- The code is matched case-insensitively, and if found, returns the corresponding country.

- If no country is found, a custom exception is thrown.


### 📦 Dependencies
**pom.xml:**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>om.cognizant.spring-learn</groupId>
	<artifactId>spring-learn</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-learn</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>


		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>

		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
			<version>2.3.5</version>
		</dependency>



		<dependency>
			<groupId>jakarta.annotation</groupId>
			<artifactId>jakarta.annotation-api</artifactId>
			<version>2.1.1</version>
		</dependency>


	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>


```

### Codes 

### Dummy data : countries.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<countries>
    <country>
        <code>IN</code>
        <name>India</name>
    </country>
    <country>
        <code>US</code>
        <name>United States</name>
    </country>
    <country>
        <code>DE</code>
        <name>Germany</name>
    </country>
    <country>
        <code>JP</code>
        <name>Japan</name>
    </country>
</countries>

```

### Coutry.java - Model class 

```java
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

```

### CoutryList.java - Wrapper for Country List 

```java
package com.cognizant.spring_learn.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "countries")
public class CountryList {

    private List<Country> countries;

    @XmlElement(name = "country")
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}

```

### CoutryService.java - Service Class

```java
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

```

### CoutryController.java - Controller class 

```java
package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws Exception {
        return countryService.getCountry(code);
    }
}

```

### SpringLearnApplication.java - Main Application Class

```java
package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}

}

```