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

### Country.java – Model Class

```java 
package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode()");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode()");
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName()");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

```

### ountry.xml – Spring Configuration File

```xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="country" class="com.cognizant.springlearn.Country">
        <property name="code" value="IN" />
        <property name="name" value="India" />
    </bean>

</beans>


```

### SpringLearnApplication.java – Main Class 

```java

package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        displayCountry();
    }

    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = (Country) context.getBean("country");
        LOGGER.debug("Country : {}", country.toString());
    }
}


```
---

## Output 

- **Output in terminal -**

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.1.2\lib\idea_rt.jar=51214" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 02 - Hands-on-4 - Spring Core - Load Country from Spring Configuration XML\target\classes;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-context\7.0.0-M6\spring-context-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-aop\7.0.0-M6\spring-aop-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-beans\7.0.0-M6\spring-beans-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-core\7.0.0-M6\spring-core-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\commons-logging\commons-logging\1.3.5\commons-logging-1.3.5.jar;C:\Users\DESKTOP\.m2\repository\org\jspecify\jspecify\1.0.0\jspecify-1.0.0.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-expression\7.0.0-M6\spring-expression-7.0.0-M6.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-observation\1.15.1\micrometer-observation-1.15.1.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-commons\1.15.1\micrometer-commons-1.15.1.jar;C:\Users\DESKTOP\.m2\repository\org\slf4j\slf4j-api\2.1.0-alpha1\slf4j-api-2.1.0-alpha1.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-classic\1.5.18\logback-classic-1.5.18.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-core\1.5.18\logback-core-1.5.18.jar" com.cognizant.springlearn.SpringLearnApplication

SLF4J(I): Connected with provider of type [ch.qos.logback.classic.spi.LogbackServiceProvider]
17:22:17.245 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext -- Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@649d209a
17:22:18.357 [main] DEBUG org.springframework.beans.factory.xml.XmlBeanDefinitionReader -- Loaded 1 bean definitions from class path resource [country.xml]
17:22:18.539 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'country'
17:22:18.541 [main] DEBUG com.cognizant.springlearn.Country -- Inside Country Constructor.
17:22:18.716 [main] DEBUG com.cognizant.springlearn.Country -- Inside setCode()
17:22:18.716 [main] DEBUG com.cognizant.springlearn.Country -- Inside setName()
17:22:18.776 [main] DEBUG com.cognizant.springlearn.SpringLearnApplication -- Country : Country{code='IN', name='India'}

Process finished with exit code 0
```
- **Screenshot -**

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2002%20-%20Hands-on-4%20-%20Spring%20Core%20-%20Load%20Country%20from%20Spring%20Configuration%20XML/Output_Screenshot/output.png?raw=true)