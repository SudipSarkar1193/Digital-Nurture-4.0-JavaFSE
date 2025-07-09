# Spring Boot – Hello World RESTful Web Service

This project demonstrates a simple RESTful web service built with Spring Boot. It exposes a GET endpoint at `/hello` that returns the text "Hello World!!" using Spring Web Framework.

---

## 🧩 Use Case

A web application needs a simple REST endpoint to verify that the server is running and responding correctly. This assignment demonstrates how to:

- Create a REST controller using Spring Boot.
- Handle a GET request at `/hello`.
- Return a hardcoded response "Hello World!!".
- Log the start and end of the request processing.

---

## 🏗️ Project Structure

```bash
HelloWorld_RESTfulWebService/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── controller/
│   │   │               │   └── HelloController.java
│   │   │               └── SpringLearnApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
```

---

## Codes

### application.properties

```properties
server.port=8083
```

### HelloController.java – REST Controller

```java
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String sayHello() {
        LOGGER.info("Start of sayHello method");
        String response = "Hello World!!";
        LOGGER.info("End of sayHello method");
        return response;
    }
}
```

---

## Output

- **Firefox**: 
![output](?raw=true)
