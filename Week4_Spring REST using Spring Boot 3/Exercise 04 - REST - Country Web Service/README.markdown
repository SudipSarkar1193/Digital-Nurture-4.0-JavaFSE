# Spring Boot – REST Country Web Service

This project demonstrates a RESTful web service built with Spring Boot. It exposes an endpoint (`/country`) to return details of the country "India" loaded from a Spring XML configuration file (`applicationContext.xml`) using Spring's `ApplicationContext`.

---

## 🧩 Use Case

An airline website requires a REST API to provide country details for booking operations. This service returns the ISO code and name of the country "India" in JSON format when the `/country` endpoint is accessed.

- **Endpoint**: `GET /country`
- **Response**: `{"code": "IN", "name": "India"}`
- **Configuration**: The country details are defined as a bean in `applicationContext.xml`.

---

## 🏗️ Project Structure

```bash
spring-learn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── model/
│   │   │               │   └── Country.java
│   │   │               ├── controller/
│   │   │               │   └── CountryController.java
│   │   │               └── RestCountryWebServiceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── applicationContext.xml
├── pom.xml
├── README.md
```

---

## Codes

### pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.cognizant</groupId>
    <artifactId>spring-learn</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>RestCountryWebService</name>
    <description>REST Country Web Service</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.3</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
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

### Country.java – Model Class

```java
package com.cognizant.springlearn.model;

public class Country {
    private String code;
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

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
```

### applicationContext.xml – Spring Configuration File

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="india" class="com.cognizant.springlearn.model.Country">
        <property name="code" value="IN"/>
        <property name="name" value="India"/>
    </bean>
</beans>
```

### CountryController.java – REST Controller

```java
package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    @Qualifier("india")
    private Country country;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        return country;
    }
}
```

### RestCountryWebServiceApplication.java – Main Application

```java
package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class RestCountryWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestCountryWebServiceApplication.class, args);
    }
}
```

### application.properties

```properties
server.port=8083
```

---

##  Output

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2004%20-%20REST%20-%20Country%20Web%20Service/Output_Screenshot/OUTPUT.png?raw=true)
