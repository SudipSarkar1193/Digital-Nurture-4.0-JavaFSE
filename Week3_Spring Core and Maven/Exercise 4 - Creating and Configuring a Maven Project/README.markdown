# Library Management System - Maven Project Setup

## Project Overview
This project is part of my coursework for learning the Spring Framework. The goal of this exercise was to set up a new Maven project for a Library Management application, configure it with essential Spring Framework dependencies, and ensure compatibility with Java 21. The exercise focuses on creating the project structure, adding Spring dependencies, and configuring the Maven Compiler Plugin.

## Project Structure
```bash
LibraryManagement/
├── Output_Screenshot (Contains the output Screenshot)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/sudip/Main.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/sudip/
├── pom.xml
└── README.md
```

## Setup 
- **Java**: JDK 21
- **Maven**: 3.8.0 
- **IDE**: IntelliJ IDEA Ultimate (used for development)
- **Dependencies**: Spring Framework 5.3.22 (specified in `pom.xml`)

### Steps
1. **Create the Maven Project**:
  

2. **Update pom.xml**:
   - Add dependencies for Spring Context, Spring AOP, Spring WebMVC, and the AspectJ Weaver (required for AOP).
   - Configure the Maven Compiler Plugin for Java 1.8.
   - Save the `pom.xml` and reload the Maven project in IntelliJ (use the **Maven** tab and click **Reload All Maven Projects**).



## Implementation Details
- **Maven Configuration** (`pom.xml`):
  - Added dependencies for `spring-context`, `spring-aop`, and `spring-webmvc` (version 5.3.22) to enable Spring Core, AOP, and MVC features.
  - Included `aspectjweaver` for AOP support.
  - Configured the Maven Compiler Plugin to compile with Java 1.8.
- **Tools Used**:
  - IntelliJ IDEA Ultimate for project creation and management.
  - Maven for dependency management and build automation.

## Challenges Faced
- Ensuring the correct Spring version (5.3.22) compatible with Java 1.8 was critical, as newer versions require higher Java versions.
- Reloading the Maven project in IntelliJ was necessary to resolve dependency issues after updating `pom.xml`.

## Codes

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sudip</groupId>
    <artifactId>LibraryManagement</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <spring.version>5.3.22</spring.version>
    </properties>

    <dependencies>
        <!-- Spring Context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Spring AOP -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Spring WebMVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- Required for Spring AOP -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.9</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Maven Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### Main.java 

```java
package com.sudip;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        System.out.println("Spring Context Initialized!");
        context.close();
    }
}

```

## Output Screenshot:

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Exercise%204%20-%20Creating%20and%20Configuring%20a%20Maven%20Project/Output_Screenshot/LibraryManagement.png?raw=true)