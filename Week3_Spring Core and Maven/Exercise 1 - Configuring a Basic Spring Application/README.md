# Library Management System - Spring Framework Assignment

## Project Overview
This project is part of my coursework for learning the Spring Framework. The goal was to create a basic backend for a Library Management system using Spring Core to manage books. The application demonstrates the setup of a Maven project, Spring dependency injection, and basic bean configuration using an XML-based application context.

## Project structure :
```bash
LibraryManagement/
├── output (Contains the output Screenshot)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/library/
│   │   │       ├── service/
│   │   │       │   └── BookService.java
│   │   │       └── repository/
│   │   │           └── BookRepository.java
│   │   └── resources/
│   │       └── applicationContext.xml
├── pom.xml
└── README.md
```

## Setup Instructions
### Prerequisites
- **Java**: JDK 21
- **Maven**: 3.8.0 or later
- **IDE**: IntelliJ IDEA Ultimate (used for development)
- **Dependencies**: Spring Context 7.0.0-M6 (specified in `pom.xml`)

### Output :
   
  ```
     Saving book: Feluda Series
     Book added successfully: Feluda Series

  ```

## Implementation Details
- **Maven Configuration** (`pom.xml`):
  - Added the Spring Context dependency to enable Spring Core features.
  - Configured the project to use Java 21.
- **Spring Configuration** (`applicationContext.xml`):
  - Defined two beans: `bookRepository` and `bookService`.
  - Used setter-based dependency injection to inject `BookRepository` into `BookService`.
- **Classes**:
  - `BookRepository`: A simple repository class with a `saveBook` method that prints a message to simulate saving a book.
  - `BookService`: A service class that uses `BookRepository` to add books and prints a confirmation message.
  - `Main`: The main class that loads the Spring context and tests the `BookService` by adding a book.
- **Tools Used**:
  - IntelliJ IDEA Ultimate for coding and debugging.
  - Maven for dependency management.

## Challenges Faced
- Initially, I had issues with the `applicationContext.xml` file not being recognized. I resolved this by ensuring it was placed in `src/main/resources`.
- Understanding dependency injection took some time, but configuring the beans in XML and linking them via setter injection helped clarify the concept.

## Codes :

### pom.xml 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.sudip</groupId>
    <artifactId>ConfiguringBasicSpringApplication</artifactId>
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
    </dependencies>


</project>
```

### applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Defining BookRepository Bean -->
    <bean id="bookRepository" class="com.library.repository.BookRepository"/>

    <!-- Defining BookService Bean with Dependency Injection -->
    <bean id="bookService" class="com.library.service.BookService">
        <property name="bookRepository" ref="bookRepository"/>
    </bean>
</beans>
```

### BookRepository.java 

```java
package com.library.repository;

public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Saving book: " + bookName);
    }
}
```

### BookService.java 

```java
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);
        System.out.println("Book added successfully: " + bookName);
    }
}
```

### Main.java

```java
package org.sudip;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = (BookService)context.getBean("bookService");

        // Test the service
        bookService.addBook("Feluda Series");
    }
}
```

## Output

```
  Saving book: Feluda Series
  Book added successfully: Feluda Series

```

### Screenshot :

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Exercise%201%20-%20Configuring%20a%20Basic%20Spring%20Application/output/ConfiguringBasicSpringApplication.png?raw=true)