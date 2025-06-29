# Library Management System - Spring Framework Assignment

## Project Overview
This project is part of my coursework for learning the Spring Framework. The goal was to create a basic backend for a Library Management system using Spring Core to manage books. The application demonstrates the setup of a Maven project, Spring dependency injection, and basic bean configuration using an XML-based application context.

## Project Structure
```bash
LibraryManagement/
├── Output_Screenshot (Contains the output Screenshot)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/sudip/
│   │   │       ├── service/
│   │   │       │   └── BookService.java
│   │   │       ├── repository/
│   │   │       │   ├── BookRepository.java
│   │   │       │   └── BookRepositoryImpl.java
│   │   │       └── Main.java
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


### Output
```
Saving book: Sharadindu Omnibus
Book 'Sharadindu Omnibus' added successfully.
```

## Implementation Details
- **Maven Configuration** (`pom.xml`):
  - Added the Spring Context dependency to enable Spring Core features.
  - Configured the project to use Java 21.
- **Spring Configuration** (`applicationContext.xml`):
  - Defined two beans: `bookRepository` (for `BookRepositoryImpl`) and `bookService` (for `BookService`).
  - Used setter-based dependency injection to inject `BookRepository` into `BookService`.
- **Classes**:
  - `BookRepository`: An interface with a `save` method.
  - `BookRepositoryImpl`: Implements `BookRepository` and prints a message to simulate saving a book.
  - `BookService`: A service class that uses `BookRepository` to add books and prints a confirmation message.
  - `Main`: The main class that loads the Spring context and tests `BookService` by adding a book.
- **Tools Used**:
  - IntelliJ IDEA Ultimate for coding and debugging.
  - Maven for dependency management.

## Challenges Faced
- Initially, I had issues with the `applicationContext.xml` file not being recognized. I resolved this by ensuring it was placed in `src/main/resources`.
- Understanding dependency injection took some time, but configuring the beans in XML and linking them via setter injection helped clarify the concept.

## Code
The code is based on the provided implementation with the `com.sudip` package structure. Refer to the project files (`pom.xml`, `applicationContext.xml`, `BookRepository.java`, `BookRepositoryImpl.java`, `BookService.java`, `LibraryManagementApplication.java`) for details.

### pom.xml 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sudip</groupId>
    <artifactId>ImplementingDependencyInjection</artifactId>
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

### BookRepository.java

```java
package com.sudip.repository;

public interface BookRepository {
    void save(String bookTitle);
}

```

### BookRepositoryImpl.java

```java
package com.sudip.repository;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public void save(String bookTitle) {
        System.out.println("Saving book: " + bookTitle);
    }
}
```

### BookService.java

```java
package com.sudip.service;

import com.sudip.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example method to test the injected repository
    public void addBook(String bookTitle) {
        if (bookRepository != null) {
            bookRepository.save(bookTitle);
            System.out.println("Book '" + bookTitle + "' added successfully.");
        } else {
            System.out.println("BookRepository is not initialized.");
        }
    }
}
```

### applicationContext.xml 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define BookRepository bean -->
    <bean id="bookRepository" class="com.sudip.repository.BookRepositoryImpl"/>

    <!-- Define BookService bean and inject BookRepository -->
    <bean id="bookService" class="com.sudip.service.BookService">
        <property name="bookRepository" ref="bookRepository"/>
    </bean>

</beans>
```

### Main.java 

```java
package com.sudip;

import com.sudip.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring context from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);

        // Run the service
        bookService.addBook("Sharadindu Omnibus");

    }
}
```
## Output :

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.1.2\lib\idea_rt.jar=50200" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week3_Spring Core and Maven\Exercise 2 - Implementing Dependency Injection\target\classes;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-context\7.0.0-M6\spring-context-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-aop\7.0.0-M6\spring-aop-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-beans\7.0.0-M6\spring-beans-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-core\7.0.0-M6\spring-core-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\commons-logging\commons-logging\1.3.5\commons-logging-1.3.5.jar;C:\Users\DESKTOP\.m2\repository\org\jspecify\jspecify\1.0.0\jspecify-1.0.0.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-expression\7.0.0-M6\spring-expression-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-observation\1.15.1\micrometer-observation-1.15.1.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-commons\1.15.1\micrometer-commons-1.15.1.jar" com.sudip.Main

Saving book: Sharadindu Omnibus
Book 'Sharadindu Omnibus' added successfully.

Process finished with exit code 0
```

### Screenshot :

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Exercise%202%20-%20Implementing%20Dependency%20Injection/Output_Screenshot/ImplementingDependencyInjection.png?raw=true)