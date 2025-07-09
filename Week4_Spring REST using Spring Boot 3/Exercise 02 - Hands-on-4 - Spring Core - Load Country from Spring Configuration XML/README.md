# Spring Core – Load Country from Spring Configuration XML

This project demonstrates the basic use of Spring Core with XML-based configuration. It loads a `Country` bean from a Spring configuration file (`country.xml`) and displays the country details using Spring's `ApplicationContext`.

---

## 🧩 Use Case

An airline website needs to support booking across multiple countries. Each country has a two-character ISO code and a full name. This assignment demonstrates how to:

- Define a `Country` bean in an XML configuration.
- Load the bean using Spring’s `ApplicationContext`.
- Use logging to trace constructor and method invocations.

---

## 🏗️ Project Structure

```bash

SpringLearn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── Country.java
│   │   │               └── SpringLearnApplication.java
│   │   └── resources/
│   │       └── country.xml
├── pom.xml


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

    <groupId>com.cognizant.springlearn</groupId>
    <artifactId>SpringCore_LoadCountry_from_SpringConfigurationXML</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>7.0.0-M6</version>
        </dependency>

        <!-- SLF4J and Logback for Logging -->
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.1.0-alpha1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.18</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

</project>
```

### Country.java